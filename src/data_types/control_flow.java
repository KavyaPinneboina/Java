package data_types;

public class control_flow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3,4,5,6};
		/*for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		for(int arr : array)
		{
			System.out.println(arr);
		}*/
		int i=0;
		/*while(i<array.length)
		{
			System.out.println(array[i]);
			i++;
		}*/
		do
		{
			System.out.println(array[i]);
			i++;
		}while(i==1);
		//System.out.println(i);

	}

}
