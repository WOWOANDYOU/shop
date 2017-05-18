package cn.edu.zhku.jsj.factory;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	
	private static Properties prop = new Properties();
	private DaoFactory(){
		try{
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("cn/edu/zhku/jsj/factory/dao.properties");//���Ҿ��и������Ƶ���Դ��
			prop.load(in);//���������ж�ȡ�����б�����Ԫ�ضԣ���
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	};
	private static final DaoFactory instance = new DaoFactory();
	public static DaoFactory getInstance(){
		return instance;
	}
	
	//BookDao.class
	public <T> T createDao(Class<T> interfaceClass){
		try{
			String key = interfaceClass.getSimpleName();//����Դ�����и����ĵײ���ļ�ơ�
			String className = prop.getProperty(key);// ��ָ���ļ��ڴ������б����������ԡ�
			return (T) Class.forName(className).newInstance();// ��������и����ַ����������ӿ�������� Class ����//������ Class ��������ʾ�����һ����ʵ����
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
