package com.rwby.mytask.log;

import android.os.Environment;

import com.rwby.mytask.BuildConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 */
public class Logdog {
	private FileOutputStream mFileOutputStream;
	private SimpleDateFormat mDateFormat;
	private static Logdog sLogdog = null;
	private int mCount = 0;
	private boolean mIgnore = false;
	private String mDir = "AJBMobileTerlog/";

	private Logdog() {
		creatOutput();
	}

	static private Logdog instance() {
		if (sLogdog == null) {
			sLogdog = new Logdog();
		}
		return sLogdog;
	}

	static public void d(String log) {
		if (BuildConfig.DEBUG) {
			Logdog.instance().writeLog("debug", log);
		}
	}

	static public void e(String log) {
		if (BuildConfig.DEBUG) {
			Logdog.instance().writeLog("error", log);
		}
	}

	static public void i(String log) {
		if (BuildConfig.DEBUG) {
			Logdog.instance().writeLog("info", log);
		}
	}

	synchronized private void writeLog(String level, String log) {
		if (mIgnore) {
			return;
		}
		try {
			Date date = new Date(System.currentTimeMillis());
			String tempString = mCount + "    " + mDateFormat.format(date)
					+ "    " + level + "    " + log + "\r\n";
			mCount++;
			mFileOutputStream.write(tempString.getBytes("UTF-8"));
			if (mCount >= 10000) {
				this.creatOutput();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (mCount % 10 == 0) {
				this.creatOutput();
			}
		}
	}

	private void creatOutput() {
		if (mFileOutputStream != null) {
			try {
				mFileOutputStream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			mFileOutputStream = null;
		}
		if (mDateFormat == null) {
			mDateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm:ss", Locale.CHINA);
		}
		String sdpathString = getSDPath();
		if (sdpathString == null) {
			return;
		}
		if (!sdpathString.endsWith("/")) {
			sdpathString += "/";
		}
		sdpathString += mDir;
		Date curDate = new Date();
		SimpleDateFormat tDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
		SimpleDateFormat hDateFormat = new SimpleDateFormat("HHmmss", Locale.CHINA);
		String fileString = null;
		try {
			fileString = sdpathString + tDateFormat.format(curDate);
		} catch (Exception e) {
			// TODO: handle exception
			fileString = sdpathString + (System.currentTimeMillis() / 1000);
		}

		File f = new File(fileString);
		f.mkdirs();
		String fileNameString = null;
		try {
			fileNameString = hDateFormat.format(curDate);
		} catch (Exception e) {
			// TODO: handle exception
			fileNameString = "" + System.currentTimeMillis() / 1000;
		}
		fileString += "/" + fileNameString + ".txt";
		try {
			mFileOutputStream = new FileOutputStream(fileString, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED); // 判断sd卡是否存
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();
		} else {
			return null;
		}
		return sdDir.toString();
	}

	static public void closeLogdog() {
		if (sLogdog != null) {
			try {
				sLogdog.close();
				sLogdog = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void close() throws IOException {
		mFileOutputStream.close();
		mFileOutputStream = null;
	}
}
