package java_bean;

public class java_bean {
	   String [] tableZidun;       //��ű��ֶ���
	   String [][] tableRecord;   //��Ų�ѯ���ļ�¼
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
