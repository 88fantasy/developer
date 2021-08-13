package org.exframework.business.developer.portal.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.exframework.business.developer.portal.dto.*;
import org.exframework.business.developer.portal.entity.UserGroup;
import org.exframework.business.developer.portal.mapper.UserGroupMapper;
import org.exframework.business.developer.portal.mapper.UserMapper;
import org.exframework.portal.jdbc.entity.AccountRoleDO;
import org.exframework.portal.jdbc.mapper.AccountRoleMapper;
import org.exframework.portal.service.sys.PortalCorePermissionService;
import org.exframework.portal.web.dto.PostConditionQueryRequest;
import org.exframework.support.common.entity.FilterCondition;
import org.exframework.support.common.entity.FilterCondition.FilterConditionOper;
import org.exframework.support.common.util.BeanUtils;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.entity.ApiResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author rwe
 * @version 创建时间：2021年6月18日 上午10:38:31 权限业务类
 */

@Service
public class AdminPermissionService {

	@Autowired
	PortalCorePermissionService portalCorePermissionService;

	@Autowired
	AdminUserService adminUserService;

	@Autowired
	AccountRoleMapper accountRoleMapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserGroupMapper userGroupMapper;

	public ApiResponseData<GroupListResponse> addGroup(GroupSaveDTO group) {
		UserGroup userGroup = BeanUtils.copyTo(group, UserGroup.class);
		userGroupMapper.insert(userGroup);
		return new ApiResponseData<>(BeanUtils.copyTo(userGroup, GroupListResponse.class));
	}

	public ApiResponseData<List<GroupListResponse>> listGroup() {
		List<UserGroup> groups = userGroupMapper.selectList(Wrappers.emptyWrapper());
		return new ApiResponseData<>(groups.stream().map(g -> {
			GroupListResponse group = new GroupListResponse();
			group.setId(g.getId());
			group.setName(g.getName());
			group.setCreateTime(g.getCreateTime());
			return group;
		}).collect(Collectors.toList()));
	}

	public ApiResponsePage<DeveloperAccountListResponse> queryAccount(String code, PostConditionQueryRequest request) {
		List<String> accounts = accountRoleMapper
				.selectList(Wrappers.<AccountRoleDO>lambdaQuery().eq(AccountRoleDO::getRole, code)).stream()
				.map(AccountRoleDO::getAccount).collect(Collectors.toList());
		if (accounts.size() > 0) {
			List<FilterCondition> conditions = new ArrayList<>();
			if (request.getConditions().length > 0) {
				conditions.addAll(Arrays.asList(request.getConditions()));
			}
			conditions.add(new FilterCondition("account", FilterConditionOper.IN, accounts));
			return new ApiResponsePage<>(
					userMapper.query(conditions.toArray(new FilterCondition[0]), request.getPage(),
							request.getSorts(), account -> new DeveloperAccountListResponse(adminUserService.loadAccount(account.getAccount())), DeveloperAccountListResponse.class));
		} else {
			return ApiResponsePage.empltyPage();
		}
	}

	public ApiResponseData<List<DeveloperPermissionListResponse>> listPermissions() {
//		Map<String, PermissionGroup> groups = portalCorePermissionService.getPermissionGroups();
//		return new ApiResponseData<>(groups.values().stream().map(g -> {
//			DeveloperPermissionListResponse permission = new DeveloperPermissionListResponse();
//			permission.setCode(g.getCode());
//			permission.setTitle(g.getName());
//			permission.setPermissions(g.getPermissions().stream().map(PermissionDTO::new).collect(Collectors.toList()));
//			return permission;
//		}).collect(Collectors.toList()));
		return new ApiResponseData<>(Collections.emptyList());
	}

}
