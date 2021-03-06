package kr.co.coffee.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import kr.co.coffee.ingredient.domain.IngredientVO;


public class ingExcelDown extends MenuExcelDown{
	
	public String ing_writeExcel(String filePath,String excelFileName,List<IngredientVO> data)throws IOException{
		super.setFilePath(filePath);
		super.setExcelFileName(excelFileName);
		FileOutputStream out = setFile(this.getFilePath(),this.getExcelFileName());
	    
		// create a new workbook
		HSSFWorkbook  wb =  ing_createExcel(data);
		try{
			wb.write(out);
		}finally{
			out.close();
			wb.close();
		}
		
		return super.getChangFileName();
	}
	/**
	 * 엑셀 시트 생성 메소드
	 * @param data
	 * @return HSSFWorkbook
	 */
	public HSSFWorkbook ing_createExcel(List<?> data){
	   setWorkbook(new HSSFWorkbook());
	   HSSFSheet sheet = getWorkbook().createSheet("sellList");
       
       // ## Font Setting
       // @HSSFFont : 폰트 설정
       //  - FONT_ARIAL : 기본
       HSSFFont font = getWorkbook().createFont();
       font.setFontName("맑은 고딕");
       
       // 머리말행 폰트 설정
       HSSFFont titleFont = getWorkbook().createFont();
       titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
       titleFont.setFontHeightInPoints((short)13);
       titleFont.setFontName("맑은 고딕");
       
        
       // ## Title Style Setting
       // @HSSFColor : 셀 배경색
       //  - GREY_$_PERCENT : 회색 $ 퍼센트
       // @HSSFCellStyle
       //  - ALIGN_$ : $ 쪽 정렬
       HSSFCellStyle titleStyle = getWorkbook().createCellStyle();
       titleStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
       titleStyle.setFillPattern(HSSFCellStyle.ALIGN_LEFT);
       titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
       titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
       titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
       titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
       titleStyle.setFont(titleFont);
       
        
       // ## Row Create
       // 가로열 생성
       HSSFRow row = sheet.createRow((short)getFirstRow());
        
       // ## Title Cell Create
       // @row.createCell((short)n) : n번째 셀 설정
       // @setCellValue(String) : n 번째 셀의 내용
       // @setCellStyle(style) : n 번째 셀의 스타일
       HSSFCell cell_0 = row.createCell((short)0+getFirstCol());
       cell_0.setCellValue("원재료코드");
       cell_0.setCellStyle(titleStyle);
        
       HSSFCell cell_1 = row.createCell((short)1+getFirstCol());
       cell_1.setCellValue("원재료명");
       cell_1.setCellStyle(titleStyle);
        
       HSSFCell cell_2 = row.createCell((short)2+getFirstCol());
       cell_2.setCellValue("원재료단가");
       cell_2.setCellStyle(titleStyle);
        
       HSSFCell cell_3 = row.createCell((short)3+getFirstCol());
       cell_3.setCellValue("1단위별 용량");
       cell_3.setCellStyle(titleStyle);

       HSSFCell cell_4 = row.createCell((short)4+getFirstCol());
       cell_4.setCellValue("용량단위");
       cell_4.setCellStyle(titleStyle);
       
       HSSFCell cell_5 = row.createCell((short)5+getFirstCol());
       cell_5.setCellValue("원재료등록날짜");
       cell_5.setCellStyle(titleStyle);
       
       HSSFCell cell_6 = row.createCell((short)6+getFirstCol());
       cell_6.setCellValue("수정날짜");
       cell_6.setCellStyle(titleStyle);
       
       
       // ## Content Style Setting
       HSSFCellStyle contentStyle = getWorkbook().createCellStyle();
       contentStyle.setFont(font);
        
       //  Content align : center
       HSSFCellStyle styleCenter = getWorkbook().createCellStyle();
       styleCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
       styleCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       styleCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
       styleCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
       styleCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
       styleCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       styleCenter.setFont(font);
        
       //  Content align : left
       HSSFCellStyle styleLeft = getWorkbook().createCellStyle();
       styleLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
       styleLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       styleLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
       styleLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
       styleLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
       styleLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       styleLeft.setFont(font);
       
       //  Content align : left
       HSSFCellStyle styleRight = getWorkbook().createCellStyle();
       styleRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
       styleRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       styleRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
       styleRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
       styleRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
       styleRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       styleRight.setFont(font);
       
       // Content vertical align : center
       HSSFCellStyle verticalCenter = getWorkbook().createCellStyle();
       verticalCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       verticalCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
       verticalCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
       verticalCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
       verticalCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       verticalCenter.setFont(font);
       
       HSSFCellStyle conStyle = getWorkbook().createCellStyle();
       conStyle.setWrapText(true);
       conStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
       conStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       conStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
       conStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
       conStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
       conStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       conStyle.setFont(font);
       
       //  ObjectList 가 비어있으면 제목만 출력 후 종료
       if(data == null) return getWorkbook();
        
       //  ObjectList 엑셀에 출력
       for(int i = 0; i < data.size(); i++){
    	   
           // 1번째 행은 제목이니 건너 뜀
           row = sheet.createRow((short)ingExcelDown.getFirstRow()+(i+1));
           IngredientVO ingredientVO = (IngredientVO)data.get(i);
           
           // 원재료코드
           cell_0 = row.createCell((short)0+getFirstCol());
           cell_0.setCellValue(ingredientVO.getIng_cd());
           cell_0.setCellStyle(styleCenter);      
           
           // 원재료명
           cell_1 = row.createCell((short)1+getFirstCol());
           cell_1.setCellValue(ingredientVO.getIng_nm());
           cell_1.setCellStyle(styleCenter);
           
           // 원재료 단가
           cell_2 = row.createCell((short)2+getFirstCol());
           cell_2.setCellValue(ingredientVO.getIng_price().toString());
           cell_2.setCellStyle(styleLeft);
           
           // 1단위별 용량 
           cell_3 = row.createCell((short)3+getFirstCol());
           cell_3.setCellValue(ingredientVO.getUnit_amount().toString());
           cell_3.setCellStyle(styleRight);
           
           // 용량 단위
           cell_4 = row.createCell((short)4+getFirstCol());
           cell_4.setCellValue(ingredientVO.getIng_unit());
           cell_4.setCellStyle(conStyle);
           //sheet.setColumnWidth(cell_4.getColumnIndex(), 8400);
           
           // 등록일
           cell_5 = row.createCell((short)5+getFirstCol());
           cell_5.setCellValue(ingredientVO.getIn_reg_dt());
           cell_5.setCellStyle(styleCenter);          
           
           // 수정일
           cell_6 = row.createCell((short)6+getFirstCol());
           cell_6.setCellValue(ingredientVO.getIn_mod_dt());
           cell_6.setCellStyle(styleCenter);    
       }
        
       //컬럼사이즈
       for(int i=0; i<8; i++){
    	   if(i==0){
    		   sheet.setColumnWidth(0,700);
    	   }else{
    		   sheet.autoSizeColumn((short)i);
    		   sheet.setColumnWidth(i, (sheet.getColumnWidth(i))+512 );  // 윗줄만으로는 컬럼의 width 가 부족하여 더 늘려야 함.
    	   }
       }
       
       // sheet.setColumnWidth(cell_4.getColumnIndex(), 12000);
       
       
       return getWorkbook();
   }
}
