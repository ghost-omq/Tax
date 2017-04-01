package omq.user;

import java.util.Date;

import omq.model.Complain;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class User extends Model<User>{
	
	public static final User me = new User().dao();
	public static final String USER_STATE_VALID = null;
	
	public Page<User> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from user order by id asc");
	}
	
	private String id;
	private String dept;
	private String headImg;
	private String name;
	private String account;
	private String password;
	private String gender;
	private String user;
	private String email;
	private String mobile;
	private Date birthday;
	private String state;
	private String memo;
	
	public String getId() {
		return get("id");
	}
	public void setId(String id) {
		set("id",id);
	}
	public String getDept() {
		return get("dept");
	}
	public void setDept(String dept) {
		set("dept",dept);
	}
	public String getHeadImg() {
		return get("headImg");
	}
	public void setHeadImg(String headImg) {
		set("headImg",headImg);
	}
	public String getName() {
		return get("name");
	}
	public void setName(String name) {
		set("name",name);
	}
	public String getAccount() {
		return get("account");
	}
	public void setAccount(String account) {
		set("account",account);
	}
	public String getPassword() {
		return get("password");
	}
	public void setPassword(String password) {
		set("password",password);
	}
	public String getGender() {
		return get("gender");
	}
	public void setGender(String gender) {
		set("gender",gender);
	}
	public String getUser() {
		return get("user");
	}
	public void setUser(String user) {
		set("user",user);
	}
	public String getEmail() {
		return get("email");
	}
	public void setEmail(String email) {
		set("email",email);
	}
	public String getMobile() {
		return get("mobile");
	}
	public void setMobile(String mobile) {
		set("mobile",mobile);
	}
	public Date getBirthday() {
		return get("birthday");
	}
	public void setBirthday(Date birthday) {
		set("birthday",birthday);
	}
	public String getState() {
		return get("state");
	}
	public void setState(String state) {
		set("state",state);
	}
	public String getMemo() {
		return get("memo");
	}
	public void setMemo(String memo) {
		set("memo",memo);
	}
	
}
