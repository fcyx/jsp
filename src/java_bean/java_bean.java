package java_bean;

public class java_bean {
	   String [] tableZidun;       //存放表字段名
	   String [][] tableRecord;   //存放查询到的记录
	   int pageSize=1;
	   int totalPages=1;
	   int currentPage = 1;
	   public void setTableZidun(String [] a){
	      tableZidun=a;
	   }
	   public String [] getTableZidun(){
	      return tableZidun;
	   }
	   public void setTableRecord(String [][] b){
	      tableRecord=b;
	   }
	   public String [][] getTableRecord(){
	      return tableRecord;
	   }
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getTotalPages() {
			return totalPages;
		}
		public void setTotalPages(int totalPages) {
			this.totalPages = totalPages;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
	}
