/* ------------------------------------------------------------------------------
 * Project       : NextEP Project VPA System
 * Source        : HelloMessage.java
 * Author        : 김청욱
* Copyright 2017 LG CNS All rights reserved
*------------------------------------------------------------------------------ */

/**
 * <PRE>
 * test
 * </PRE>
 * 
 * @author 김청욱
 * @version v1.0 2017. 8. 23.
 */
package message;
 
import java.util.Date;


public class HelloMessage2 {

	private String name;
	private String contents;
	private Date sendDate;
	private int imageNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	
	
}

