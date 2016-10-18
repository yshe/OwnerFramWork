package leap.demo.util.common.Sequence;

public class Sequence {
	public static void main(String[] args) {
		int a[]={10,23,11,56,45,26,59,28,84,79};       	//给出原始数的序列
		//Bubble (a);冒泡排序
	   // quick(a, 0, 5);//快速排序
	   // select(a);//选择排序
		//insert(a);//插入排序
		int b[]=new int[10];
		mergeS(a,b,a.length);//归并排序
		//mergePass(a,b,a.length-1,1);
	    for(int i=0;i<a.length;i++){  	
        	System.out.print(a[i]+"  ");
    }
	}

	/**
	 * 布尔排序
	 * @param a
	 */
	private static void Bubble (int[] a) {
		int temp=0;
	    for(int i=0;i<a.length;i++){
	    	for(int j=0;j<a.length-i-1;j++)
	    		if(a[j]>a[j+1]){     				//进行两两比较，下面进行符合条件的交换
	    			temp=a[j+1];
	            	a[j+1]=a[j];
	            	a[j]=temp;
	    		}
	    }
	}
	
	
	/**
	 * 快速排序
	 * @param r
	 * @param first
	 * @param end
	 */
	public static void quick(int[] r,int first,int end){    //利用递归反复划分
		if(first<end){
			int pivot=partition(r, first, end);           //调用划分函数
			quick(r,first,pivot-1);
			quick(r,pivot+1,end);
		}
	}
	public  static int partition(int[] r,int first,int end){
		int i,j;
		i=first;j=end;                        //初始化
		while(i<j){
			while(i<j&&r[i]<=r[j])  j--;      //右侧扫描
			if(i<j){                          //将较小的记录交换到前面
				int temp;
				temp=r[i];
				r[i]=r[j];
				r[j]=temp;
			}
			while(i<j&&r[i]<r[j]){
				i++;                           //左侧扫描
			}
			if(i<j){                           //将较大的记录换到后面
				int temp;
				temp=r[i];
				r[i]=r[j];
				r[j]=temp;
			}
		}
		return i;//
	}
	
	
	
	/**
	 * 选择排序
	 */
	
	public static void select(int[] r){
		int i,j,index,temp;
		for(i=0;i<9;i++){
			index=i;                      //初始化第i趟选择排序的最小记录的指针
			for(j=i+1;j<10;j++){          //在无序区选取最小记录
				if(r[j]<r[index]){
					index=j;
				}
			}
			if(index!=i){                 //将最小记录与r[i]交换
				 temp=r[i];
				 r[i]=r[index];
				 r[index]=temp;
			}
		}
	}
	
	/**
	 * 插入排序
	 * @param r
	 */
	public static void insert(int[] r){
		 int i,j,temp;      
		for(i=1;i<10;i++){
			temp=r[i];                         //设置哨兵，暂存当前值
			for(j=i-1;j>=0&&temp<r[j];j--){    //寻找插入位置
				r[j+1]=r[j];
				}
			r[j+1]=temp;               //大于当前值的插到当前值后面
			}
	}
	
	
	/**
	 * 归并排序
	 */
	private static void merge(int r[],int r1[],int s,int m,int t){
		int i=s,j=m+1,k=s;
		while(i<=m&&j<=t){
			if(r[i]<=r[j]){
				r1[k++]=r[i++];       //取r[i]和r[j]中较小者放入r1[k]
			}
			else{
				r1[k++]=r[j++];
			}
		}
		if(i<=m){
			while(i<=m){              //若第一个子序列处理完，则进行收尾处理
				r1[k++]=r[i++];
			}
		}
		else{
			while(j<=t){              //若第二个子序列处理完，则进行收尾处理
				r1[k++]=r[j++];
			}
		}
	}
	private static void mergePass(int r[],int r1[],int n,int h){
		int i=0;
		while(i<=n-2*h){              //待归并记录至少有两个长度为h的子序列
			merge(r,r1,i,i+h-1,i+2*h-1);
			i+=2*h;
		}
		if(i<n-h){
			merge(r,r1,i,i+h-1,n);    //待归并序列中有一个长度小于h
		}
		else{
			for(int k=i;k<=n;k++){    //待归并序列中只剩一个子序列
				r1[k]=r[k];
			}
		}
	}
	public static void mergeS(int r[],int r1[],int n){
		int h=1;
		while(h<n){
			mergePass(r,r1,n-1,h);
			h=2*h;
			mergePass(r1,r,n-1,h);
			h=2*h;
		}
	}

}
