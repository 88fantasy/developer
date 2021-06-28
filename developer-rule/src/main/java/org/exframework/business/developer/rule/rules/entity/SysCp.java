package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author dhx
 * @since 2021-05-11
 */
@TableName("sys_cp")
public class SysCp implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @TableId
	private Long cpid;
	
	@TableField
	private Long opid;
	
	@TableField
	private String eventname;
	
	@TableField
	private String eventparam;
	
	@TableField
	private boolean menuflag;
	
	@TableField
	private String menutext;
	
	@TableField
	private Integer menupos;
	
	@TableField
	private boolean useaccel;
	
	@TableField
	private String vkey;
	
	@TableField
	private String keycode;

	public Long getCpid() {
		return cpid;
	}

	public void setCpid(Long cpid) {
		this.cpid = cpid;
	}

	public Long getOpid() {
		return opid;
	}

	public void setOpid(Long opid) {
		this.opid = opid;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventparam() {
		return eventparam;
	}

	public void setEventparam(String eventparam) {
		this.eventparam = eventparam;
	}

	public boolean isMenuflag() {
		return menuflag;
	}

	public void setMenuflag(boolean menuflag) {
		this.menuflag = menuflag;
	}

	public String getMenutext() {
		return menutext;
	}

	public void setMenutext(String menutext) {
		this.menutext = menutext;
	}

	public Integer getMenupos() {
		return menupos;
	}

	public void setMenupos(Integer menupos) {
		this.menupos = menupos;
	}

	public boolean isUseaccel() {
		return useaccel;
	}

	public void setUseaccel(boolean useaccel) {
		this.useaccel = useaccel;
	}

	public String getVkey() {
		return vkey;
	}

	public void setVkey(String vkey) {
		this.vkey = vkey;
	}

	public String getKeycode() {
		return keycode;
	}

	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}
    
}
