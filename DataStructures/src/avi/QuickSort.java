package avi;

public class QuickSort {
	public static void main(String args[]){
		int[] array={18,7,19,36,21,1,8,11};
		quicksort(array,0,7);
	}
	static void quicksort(int array[ ],int start,int end)
	{ 	int pivot, i, j, n= end;
		if (start<end)
		{ 	pivot=start;
			i=start;
			j=end;
			while(i<=j)
			{
			while(array[i]<array[pivot] && i<=j)  	i++;
			while(array[j]>array[pivot] && i<=j) 	j--;
				if(i<=j)
					swap(array,i,j);
				if(array[j]==array[pivot]){
					pivot = j;
				}else if(array[i]==array[pivot]){
					pivot = i;
				}
			}
			swap(array,pivot,j);
			for(int y=0; y<=n;y++){
				System.out.println(array[y]);
			}
			
		quicksort(array,start,j-1); // sort first partition
		quicksort(array,j+1,end); // sort second partition 
			}
		}

	static void swap(int arr[],int i,int j)
	{
	    int temp;
	    temp=arr[i];
	    arr[i]=arr[j];
	    arr[j]=temp;
	}

}
