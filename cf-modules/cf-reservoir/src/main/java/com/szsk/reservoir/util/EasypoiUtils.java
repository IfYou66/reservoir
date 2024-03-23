package com.szsk.reservoir.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Workbook;

import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.web.domain.BaseEntity;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;

public class EasypoiUtils {

	 /**
     * 对Object数据源将其里面的数据导入到excel表单
     * 
     * @param response 返回数据
     * @param object 导出数据集合
     * @return 结果
     * @throws IOException
     */
    public static void exportExcelByTemplate(HttpServletResponse response,Map<String,Object> map ,String templateUrl) throws IOException
    {
    	OutputStream out = response.getOutputStream();
    	
    	try {
			 
	    	TemplateExportParams params = new TemplateExportParams(templateUrl);
	    	Workbook workbook = ExcelExportUtil.exportExcel(params, map);
	 		
			String fileName = DateUtils.getTime()+".xls";
			response.setContentType("application/octet-stream");  
            response.setHeader("name", fileName);  
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");  
            response.setHeader("Pragma", "public");  
            response.setDateHeader("Expires", 0);  
            response.setHeader("Content-disposition","attachment; filename=\""+URLEncoder.encode(fileName, "UTF-8")+ "\"");
			workbook.write(out);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.flush();
			out.close();
		}
    	
    }
}
