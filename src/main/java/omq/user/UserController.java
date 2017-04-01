package omq.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import omq.poi.PoiPush;
import omq.poi.PoiUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;

public class UserController<HttpServletResponse> extends Controller{
	
	private User user = new User().dao();
	
	public void index(){
		Page<User> paginate = User.me.paginate(getParaToInt(0, 1), 10);
		Controller setAttr = setAttr("userPage",paginate);
		render("listUI.html");
		
	}
	
	public void add(){
		render("addUI.html");
	}
	
	public void save(){	
		UploadFile file = getFile("user.headImg");
		if(file == null){
			User model = getModel(User.class);
			String id = UUID.randomUUID().toString().replace("-", "");
			model.setId(id);
			model.save();
			redirect("/user");
		}else{
			User model = getModel(User.class);
			String fileName = file.getFileName();
			model.setHeadImg(fileName);
			String id = UUID.randomUUID().toString().replace("-", "");
			model.setId(id);
			model.save();
			redirect("/user");
		}
	}
	
	public void edit(){
		String para = getPara();
		User findById = user.findById(para);
		setAttr("user", findById);
		render("editUI.html");
	
	}
	
	public void update(){
		User model = getModel(User.class);
		model.update();
		redirect("/user");
	}
	
	
	public void delete(){
		String para = getPara();
		boolean deleteById = user.deleteById(para);
		redirect("/user");
	}
	
	
	public void deleteAll(){
		
		for(String id : getParaValues("selectedRow")){
			for(int i = 0 ; i < 10; i ++){
				boolean deleteById = user.deleteById(id);
			}
		}
		redirect("/user");
	}
	
	public void push() throws IOException{
		//1、获取excel文件
		UploadFile file = getFile("userExcel");
				if(file != null){
					//2、导入
					FileInputStream fileInputStream = new FileInputStream(file.getFile());
					//boolean is03Excel = userExcelFileName.matches("^.+\\.(?i)(xls)$");
					//1、读取工作簿
					Workbook workbook = new HSSFWorkbook(fileInputStream);
					//2、读取工作表
					Sheet sheet = workbook.getSheetAt(0);
					//3、读取行
					if(sheet.getPhysicalNumberOfRows() > 2){
						for(int k = 1; k < sheet.getPhysicalNumberOfRows(); k++){
							User model = getModel(User.class);
							String id = UUID.randomUUID().toString().replace("-", "");
							model.setId(id);
							//4、读取单元格
							Row row = sheet.getRow(k);
							//用户名
							Cell cell0 = row.getCell(0);
							model.setName(cell0.getStringCellValue());
							//帐号
							Cell cell1 = row.getCell(1);
							model.setAccount(cell1.getStringCellValue());
							//所属部门
							Cell cell2 = row.getCell(2);
							model.setDept(cell2.getStringCellValue());
							//性别
							Cell cell3 = row.getCell(3);
							model.setGender(cell3.getStringCellValue());
							//手机号
							String mobile = "";
							Cell cell4 = row.getCell(4);
							try {
								mobile = cell4.getStringCellValue();
							} catch (Exception e) {
								double dMobile = cell4.getNumericCellValue();
								mobile = BigDecimal.valueOf(dMobile).toString();
							}
							model.setMobile(mobile);
							
							//电子邮箱
							Cell cell5 = row.getCell(5);
							model.setEmail(cell5.getStringCellValue());
							//生日
							Cell cell6 = row.getCell(6);
							if(cell6.getDateCellValue() != null){
								model.setBirthday(cell6.getDateCellValue());
							}
							//默认用户密码为 123456
							model.setPassword("123456");
							//默认用户状态为 有效
							model.setState(User.USER_STATE_VALID);
							
							//5、保存用户
							model.save();
						}
					}
					workbook.close();
					fileInputStream.close();
				}
		redirect("/user");
	}
	
	public void pull(){
		File file = new File("text.xls");
        List<User> users = User.me.find("select * from user");
        PoiUtil.exportUserExcel(users,file);
        
        renderFile(file);
	}
	
}
