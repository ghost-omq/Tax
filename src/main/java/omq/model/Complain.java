package omq.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;

public class Complain extends Model<Complain>{
	
	private static final Complain me = new Complain();
	
	private String comp_id;
	private String comp_company;
	private String comp_name;
	private String comp_mobile;
	private Integer is_NM;
	private Date comp_time;
	private String comp_title;
	private String to_comp_name;
	private String to_comp_dept;
	private String comp_content;
	private String state;
	
	public String getComp_id() {
		return get("comp_id");
	}
	public void setComp_id(String comp_id) {
		set("comp_id",comp_id);
	}
	public String getComp_company() {
		return get("comp_company");
	}
	public void setComp_company(String comp_company) {
		set("comp_company",comp_company);
	}
	public String getComp_name() {
		return get("comp_name");
	}
	public void setComp_name(String comp_name) {
		set("comp_name",comp_name);
	}
	public String getComp_mobile() {
		return get("comp_mobile");
	}
	public void setComp_mobile(String comp_mobile) {
		set("comp_mobile",comp_mobile);
	}
	public Integer getIs_NM() {
		return get("is_NM");
	}
	public void setIs_NM(Integer is_NM) {
		set("is_NM",is_NM);
	}
	public Date getComp_time() {
		return get("comp_time");
	}
	public void setComp_time(Date comp_time) {
		set("comp_time",comp_time);
	}
	public String getComp_title() {
		return get("comp_title");
	}
	public void setComp_title(String comp_title) {
		set("comp_title",comp_title);
	}
	public String getTo_comp_name() {
		return get("to_comp_name");
	}
	public void setTo_comp_name(String to_comp_name) {
		set("to_comp_name",to_comp_name);
	}
	public String getTo_comp_dept() {
		return get("to_comp_dept");
	}
	public void setTo_comp_dept(String to_comp_dept) {
		set("to_comp_dept",to_comp_dept);
	}
	public String getComp_content() {
		return get("comp_content");
	}
	public void setComp_content(String comp_content) {
		set("comp_content",comp_content);
	}
	public String getState() {
		return get("state");
	}
	public void setState(String state) {
		set("state",state);
	}
}
