package avi.assignment6;

/**
 * @author avinash
 *
 */
public class HashMapOpenAdressing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 0;
		int initialSize = 10;
		StudentDetails arrayInput[] = new StudentDetails[20];
		StudentDetails array[] = getArrayInitialized(initialSize);
		System.out.println("The initial Hash Table elements are: ");
		traverse(array,initialSize);
		arrayInput[0] = new StudentDetails(2021111111,"ABC");
		arrayInput[1] = new StudentDetails(2021111134,"DEF");
		arrayInput[2] = new StudentDetails(2021111156,"GHI");
		arrayInput[3] = new StudentDetails(2021111140,"JKL");
		arrayInput[4] = new StudentDetails(2021111157,"LMN");
		arrayInput[5] = new StudentDetails(2021111112,"OPQ");
		arrayInput[6] = new StudentDetails(2021111143,"RST");
		arrayInput[7] = new StudentDetails(2021111189,"UVW");
		arrayInput[8] = new StudentDetails(2021111178,"XYZ");
		arrayInput[9] = new StudentDetails(2021111102,"AVI");
		arrayInput[10] = new StudentDetails(2021111101,"BOB");
		arrayInput[11] = new StudentDetails(2021111123,"CAROL");
		arrayInput[12] = new StudentDetails(2021111107,"DOLLY");
		arrayInput[13] = new StudentDetails(2021111155,"EDDIE");
		arrayInput[14] = new StudentDetails(2021111187,"FARAH");
		arrayInput[15] = new StudentDetails(2021111190,"GANES");
		arrayInput[16] = new StudentDetails(2021111456,"HITHE");
		arrayInput[17] = new StudentDetails(2021111678,"ISHAN");
		arrayInput[18] = new StudentDetails(2021111278,"JACKY");
		arrayInput[19] = new StudentDetails(2021111450,"KARAN");
		System.out.println("The Hash Table elements after creating the StudentDetails: ");
		int init = add(size,initialSize,array,arrayInput);
	}
	
	/**
	 * This method is used for initializing the array
	 * @param size
	 * @return
	 */
	public static StudentDetails[] getArrayInitialized(int size){
		StudentDetails array[] = new StudentDetails[size];
		return array;
		
	}
	
	/**
	 * This method returns the index of the Student id
	 * @param id
	 * @param initialSize
	 * @return
	 */
	public static int getIndex(int id,int initialSize){
		int index = id%initialSize;
		return index;
	}
	
	/**
	 * This method return a prime number used for changing the Hash Table size
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	
	/**
	 * This method adds the StudentDetails values to the Hash Table. If already exists, uses linear order to address the value.
	 * @param index
	 * @param value
	 * @param size
	 * @param initialSize
	 * @param array
	 * @param arrayInput
	 * @return
	 */
	public static int add(int size, int initialSize, StudentDetails array[],StudentDetails[] arrayInput){
		float loadFactor ;
		int index, init, linearValue = 1;
		for(int i=0; i<20; i++){
			index = getIndex(arrayInput[i].studentId, initialSize);
			if((array[index]==null) || (array[index].studentId != arrayInput[i].studentId)){
				
				loadFactor = (float)size/initialSize;
				if(loadFactor <= 0.5){
					if(array[index]==null){
						array[index] = new StudentDetails(arrayInput[i].studentId,arrayInput[i].name);
						System.out.println(array[index].studentId+" , " +array[index].name+" --> "+index);
						size++;
					}else{
						index = index + (linearValue);
						if(index >= initialSize){
							index = index%initialSize;
						}
						array[index] = new StudentDetails(arrayInput[i].studentId,arrayInput[i].name);
						System.out.println(array[index].studentId+" , " +array[index].name+" --> "+index);
						size++;
						linearValue++;
					}
				}else{
					initialSize = initialSize*2;
					while(!isPrime(initialSize)){
						initialSize++;
					}
					size = 0;
					linearValue = 1;
					array = getArrayInitialized(initialSize);
					System.out.println("-------------------------The load factor is changed to "+loadFactor+ "and so the table size is changed to "+initialSize+" Rehashing--------------------------");
						init =add(size,initialSize,array,arrayInput);
					if(init == 0)
						return 0;
				}
			}
		}
		traverse(array,initialSize);
		return 0;
	}
	
	/**
	 * This method traverses the Hash Table and display them.
	 * @param array
	 * @param size
	 */
	public static void traverse(StudentDetails[] array, int size){
		for(int i=0; i<size; i++){
			if(array[i] != null){
				System.out.println("The value in the Hash Table of index --> "+i+" is "+array[i].getStudentId()+" -- "+array[i].getName());
			} else {
				System.out.println("There is no elements in index -->"+i);
			}
		}
			
	}
}
