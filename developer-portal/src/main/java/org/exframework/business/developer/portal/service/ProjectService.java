package org.exframework.business.developer.portal.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.exframework.business.developer.portal.dto.ProjectResponse;
import org.exframework.business.developer.portal.entity.DeveloperAccount;
import org.exframework.business.developer.portal.entity.Project;
import org.exframework.business.developer.portal.entity.ProjectMember;
import org.exframework.business.developer.portal.mapper.ProjectMapper;
import org.exframework.business.developer.portal.mapper.ProjectMemberMapper;
import org.exframework.portal.web.dto.PostConditionQueryRequest;
import org.exframework.support.common.entity.PageModel;
import org.exframework.support.common.util.BeanUtils;
import org.exframework.support.jdbc.service.ExBaseService;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.entity.ApiResponsePage;

/**
* @author rwe
* @version 创建时间：2021年4月21日 上午11:44:21
* 项目业务逻辑类
*/

@Service
public class ProjectService extends ExBaseService<ProjectMapper, Project> {

	@Autowired
	DeveloperLoginService developerLoginService;
	
	@Autowired
	ProjectMemberMapper projectMemberMapper;
	
	@Autowired
	AdminAccountService accountService;
		
	public ApiResponsePage<ProjectResponse> pageProjectsByCurrent(PostConditionQueryRequest request) {
		DeveloperAccount account = developerLoginService.currentPerson();
		List<ProjectMember> members = projectMemberMapper.selectList(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getAccount, account.getAccount()));
		if(members.size() > 0) {
			List<String> projectIds = members.stream().map(ProjectMember::getProjectId).collect(Collectors.toList());
			PageModel<ProjectResponse> model = getBaseMapper().query(request.getPage(), Wrappers.<Project>lambdaQuery().in(Project::getId, projectIds), translator, ProjectResponse.class);
			return new ApiResponsePage<>(model);
		}
		else {
			return ApiResponsePage.EMPTY;
		}
	}
	
	public ApiResponseData<List<ProjectResponse>> getProjectsByCurrent() {
		DeveloperAccount account = developerLoginService.currentPerson();
		List<ProjectMember> members = projectMemberMapper.selectList(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getAccount, account.getAccount()));
		if(members.size() > 0) {
			List<String> projectIds = members.stream().map(ProjectMember::getProjectId).collect(Collectors.toList());
			return new ApiResponseData<>(getBaseMapper().list(Wrappers.<Project>lambdaQuery().in(Project::getId, projectIds), translator, ProjectResponse.class));
		}
		else {
			return new ApiResponseData<>(Arrays.asList());
		}
	}
	
	
	private Function<Project, ProjectResponse> translator =  entity -> {
			ProjectResponse dto = BeanUtils.copyTo(entity, ProjectResponse.class);
			String id = entity.getId();
			List<ProjectMember> pms = projectMemberMapper.selectList(Wrappers.<ProjectMember>lambdaQuery().eq(ProjectMember::getProjectId, id));
			List<String> members = pms.stream().map(pm -> {
				String account = pm.getAccount();
				return accountService.loadAccount(account).getAccountName();
			}).collect(Collectors.toList());
			dto.setMembers(members);
			return dto;
		};
		
	public Function<Project, ProjectResponse> getTranslator() {
		return translator;
	}
}
