package asclib.sys;

import java.io.File;

public class Platform {
	public final static boolean unix = System.getProperty("file.separator").equals("/");
	public final static boolean is64 = System.getProperty("sun.arch.data.model").equals("64");
	public final static String arch = System.getProperty("os.arch");
	public final static String name = System.getProperty("os.name");
	public final static String platform = pythonPlatform();
	public final static String sep = System.getProperty("file.separator");
	
	public static String pythonPlatform() {
		if (unix == false) return is64? "win64" : "win32";
		if (name.equals("Linux")) return "linux2";
		if (name.startsWith("Mac")) return "darwin";
		return "unknow";
	}
	
	public static String[] getClassPath() {
		String cp = System.getProperty("java.class.path");
		return cp.split(unix? ":" : ";");
	}
	
	/**
	 * ��������·����python�� os.path.join
	 * @param base ·��1
	 * @param path ·��2
	 * @return
	 */
	public static String pathJoin(String base, String path) {
		base = base.trim();
		path = path.trim();
		if ((new File(path)).isAbsolute()) return path;
		if (path.startsWith("/")) return path;
		if (path.startsWith("\\")) return path;
		return (new File(new File(base), path)).getPath();
	}
	
	/**
	 * python: os.path.exists
	 * @param path
	 * @return
	 */
	public static boolean pathExists(String path) {
		return (new File(path)).exists();
	}
	
	/**
	 * Python os.path.abspath
	 * @param path
	 * @return
	 */
	public static String absPath(String path) {
		return (new File(path)).getAbsolutePath();
	}
	
	/**
	 * read the whole file and returns contains
	 * @param name file path
	 * @return file bytes
	 */
	public static byte[] loadFile(String name) {
		return name.getBytes();
	}
	
	/**
	 * �� classpath�в���ģ��
	 * @param name ģ������
	 * @return
	 */
	public static String findModule(String name) {
		String[] cp = getClassPath();
		for (int i = 0; i < cp.length; i++) {
			String c = cp[i];
			String x = "";
			if (c.indexOf('*') >= 0) {
				continue;
			}
			x = absPath(pathJoin(c, name));
			if (pathExists(x)) return x;
		}
		return null;
	}
	
	/**
	 * �� classpath����������������Ϊ name + "." + platform��ģ��
	 * @param name ģ�������������win32�£�name=QuickNet���������� QuickNet.win32
	 * @throws UnsatisfiedLinkError 
	 */
	public static String loadModule(String name) {
		String modname = name + "." + platform;
		String modpath = findModule(modname);
		if (modpath == null) {
			throw new UnsatisfiedLinkError("can not find module: " + modname);
		}
		System.load(modpath);
		return modpath;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cp = getClassPath();
		for (int i = 0; i < cp.length; i++) {
			System.out.println(cp[i]);
		}
		System.out.println(System.getProperty( "sun.arch.data.model") + " " + is64 + " " + arch);
		System.out.println(System.getProperty("os.name") + " " + platform + " " + unix);
		//loadModule("QuickNet");
	}
}



