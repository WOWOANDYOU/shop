package cn.edu.zhku.jsj.web.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.exception.NotChooseFileException;
import cn.edu.zhku.jsj.exception.PictureTypeException;
import cn.edu.zhku.jsj.formbean.ClothFormBean;
import cn.edu.zhku.jsj.formbean.FoodFormBean;

//传入 request （解析 普通文本 以及 上传上来的图片） bean 的Class对象 
public class WebUtil {
		public static Book doUploadBook(HttpServletRequest request, String savepath) throws FileSizeLimitExceededException {
			Book book = new Book();
			try{
				DiskFileItemFactory factory = new DiskFileItemFactory();
			/*	factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp")));*/
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");
				upload.setFileSizeMax(1000*1000*50);
				List<FileItem> list = upload.parseRequest(request);
				
				String savefilename = "";// 用来保存 上传文件的文件名的 
				//逐个分析每个 request 输入项 判断其是普通 还是文件输入项
				for(FileItem item : list){
					if(item.isFormField()){
						String name = item.getFieldName();  //username=aaa  description=bbb
						String value = item.getString("UTF-8");
						BeanUtils.setProperty(book, name, value);// 将每个 普通输入项 数据封装到bean里 输入项的名字应该与bean属性名保持一致
					}else{
						String filename = item.getName();//获得文件名
						if(filename==null || "".equals(filename.trim())){
							throw new NotChooseFileException();
						}
						//判断该文件是什么类型  如果不是 图片类型 那么抛出一个 不是图片的异常
						String fileType = filename.substring(filename.lastIndexOf(".")+1);
						if(fileType.equals("jpg") || fileType.equals("png") || fileType.equals("jpeg") || fileType.equals("gif")){
							String uuidname  = generateredUuidname(filename);
							/*FileOutputStream out = new FileOutputStream(savepath+File.separator+uuidname);*/
							InputStream in = item.getInputStream();
							int len = 0;
							byte buffer[] = new byte[1024];
							FileOutputStream out = new FileOutputStream(savepath +File.separator+ uuidname);  //File.separator  就是 // 符号  为了 在Linux下兼容
							while((len=in.read(buffer))>0){
								out.write(buffer, 0, len);
							}
							savefilename = savefilename + uuidname + ";";   //记住上传的所有图片的名字
							in.close();
							out.close();
							item.delete();
						}else{
							throw new PictureTypeException();
						}
					}
				}
				book.setImages(savefilename);
				return book;
			}catch (FileUploadBase.FileSizeLimitExceededException e) {
				throw e;
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public static Map doUploadFood(HttpServletRequest request, String savepath) throws FileSizeLimitExceededException {
			Food food = new Food();
			FoodFormBean formbean = new FoodFormBean();
			Map map = new HashMap();
			try{
				DiskFileItemFactory factory = new DiskFileItemFactory();
			/*	factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp")));*/
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");
				upload.setFileSizeMax(1000*1000*500);
				List<FileItem> list = upload.parseRequest(request);
				
				String savefilename = "";// 用来保存 上传文件的文件名的 
				//逐个分析每个 request 输入项 判断其是普通 还是文件输入项
				for(FileItem item : list){
					if(item.isFormField()){
						String name = item.getFieldName();  //username=aaa  description=bbb
						String value = item.getString("UTF-8");
						/*System.out.println(name+"  "+value);*/
						BeanUtils.setProperty(formbean, name, value);//将数据 封住到 formbean中 以便检查数据
						BeanUtils.setProperty(food, name, value);// 将每个 普通输入项 数据封装到bean里 输入项的名字应该与bean属性名保持一致
					}else{
						if(!formbean.checkoutData()){  //如果用户 输入的数据 有误 那么返回 不在执行
							map.put("formbean", formbean);
							return map;
						}
						String filename = item.getName();//获得文件名
						if(filename==null || "".equals(filename.trim())){
							throw new NotChooseFileException();
						}
						//判断该文件是什么类型  如果不是 图片类型 那么抛出一个 不是图片的异常
						String fileType = filename.substring(filename.lastIndexOf(".")+1);
						if(fileType.equals("jpg") || fileType.equals("png") || fileType.equals("jpeg") || fileType.equals("gif")){
							String uuidname  = generateredUuidname(filename);
							/*FileOutputStream out = new FileOutputStream(savepath+File.separator+uuidname);*/
							InputStream in = item.getInputStream();
							int len = 0;
							byte buffer[] = new byte[1024];
							FileOutputStream out = new FileOutputStream(savepath +File.separator+ uuidname);  //File.separator  就是 // 符号  为了 在Linux下兼容
							while((len=in.read(buffer))>0){
								out.write(buffer, 0, len);
							}
							savefilename = savefilename + uuidname;   //记住上传的所有图片的名字  食物只上传一张图片 不需要 用 ;隔开
							/*savepath = savepath + savefilename;*/
							in.close();
							out.close();
							item.delete();
						}else{
							throw new PictureTypeException();
						}
					}
				}
				food.setImages(savefilename);
				map.put("food", food);
				return map;
				/*return food;*/
			}catch (FileUploadBase.FileSizeLimitExceededException e) {
				throw e;
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public static Map doUploadCloth(HttpServletRequest request, String savepath) throws FileSizeLimitExceededException {
			Cloth cloth = new Cloth();
			ClothFormBean formbean = new ClothFormBean();
			Map map = new HashMap();
			int num = 0;//多图上传 用来判断 对普通数据的检验是否已经完成了 第一次检查完后 +1 表示已经检查完 下次处理图片的时候 就不用在检查了
			try{
				DiskFileItemFactory factory = new DiskFileItemFactory();
			/*	factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp")));*/
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");
				upload.setFileSizeMax(1000*1000*500);
				List<FileItem> list = upload.parseRequest(request);
				
				String savefilename = "";// 用来保存 上传文件的文件名的 
				//逐个分析每个 request 输入项 判断其是普通 还是文件输入项
				for(FileItem item : list){
					if(item.isFormField()){
						String name = item.getFieldName();  //username=aaa  description=bbb
						String value = item.getString("UTF-8");
						System.out.println(name+" "+value);
						BeanUtils.setProperty(formbean, name, value);
						BeanUtils.setProperty(cloth, name, value);// 将每个 普通输入项 数据封装到bean里 输入项的名字应该与bean属性名保持一致
					}else{
						
						// 检查要求 ：上传表单要设计为  普通输入项 与 文件上传项 完全分开
						if(num==0){  //第一次要检查普通数据 检查完后  num + 1 所以下次就不用再次检查了
							if(!formbean.checkoutData()){  //如果用户 输入的数据 有误 那么返回 不在执行
								map.put("formbean", formbean);
								return map;
							}
							num++;
						}
						
						String filename = item.getName();//获得文件名
						if(filename==null || "".equals(filename.trim())){
							throw new NotChooseFileException();
						}
						//判断该文件是什么类型  如果不是 图片类型 那么抛出一个 不是图片的异常
						String fileType = filename.substring(filename.lastIndexOf(".")+1);
						if(fileType.equals("jpg") || fileType.equals("png") || fileType.equals("gif")){
							String uuidname  = generateredUuidname(filename);
							/*FileOutputStream out = new FileOutputStream(savepath+File.separator+uuidname);*/
							InputStream in = item.getInputStream();
							int len = 0;
							byte buffer[] = new byte[1024];
							FileOutputStream out = new FileOutputStream(savepath +File.separator+ uuidname);  //File.separator  就是 // 符号  为了 在Linux下兼容
							while((len=in.read(buffer))>0){
								out.write(buffer, 0, len);
							}
							savefilename = savefilename + uuidname + ",";   //记住上传的所有图片的名字 取数据的时候用 c:forToken标签取数据
							in.close();
							out.close();
							item.delete();
						}else{
							throw new PictureTypeException();
						}
					}
				}
				cloth.setImages(savefilename);
				map.put("cloth", cloth);
				return map;
			}catch (FileUploadBase.FileSizeLimitExceededException e) {
				throw e;
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		private static String generateredUuidname(String filename) {
			return UUID.randomUUID().toString()+"_"+filename;
		}
		
		//从request 中获取数据 将form表单提交过来的数据 
		/*public static <T> T getDatatoForm(HttpServletRequest request,Class<T> beanClass){
			try{
				T bean = beanClass.newInstance();
				 Enumeration ele = request.getParameterNames();
				 if(ele!=null){
					 System.out.println("ele!=null");
					 String name = (String) ele.nextElement();
					 System.out.println(name);
				 }
				 while(ele.hasMoreElements()){
					String name = (String) ele.nextElement();
					String value = request.getParameter(name);
					System.out.println(name+"  "+value);
				 	BeanUtils.setProperty(bean, name, value);//调用 beanutils 开发包中的 设置 属性值的方法  对bean 对象 的 name变量记住的属性 赋予 value变量记住的值
				 }
				 return bean;
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}*/
}
