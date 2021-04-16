package com.csw.controller;

import com.csw.util.SecurityCode;
import com.csw.util.SecurityImage;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

@Controller
@Scope(value = "prototype")
public class CaptchaAction {
	public String execute() throws Exception {
		// ������֤�������
		String securityCode = SecurityCode.getSecurityCode();
		/**
		 * �����������session,δ����������֤
		 */
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("securityCode", securityCode);

		// ����������֤��ͼƬ
		BufferedImage image = SecurityImage.createImage(securityCode);
		// ��Ӧ���ͻ���
		HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream out = response.getOutputStream();
		/**
		 * ��һ�������� ָ����֤��ͼƬ���� �ڶ��������� ͼƬ�ĸ�ʽ ������������ ָ�������
		 */
		ImageIO.write(image, "png", out);

		return null;// ����null��������ת
	}
}