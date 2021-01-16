/**

this is an OOP class 
it will have food name, number, barcode, and pointer to an image of said food




*/



public class Food
{
private:
	int numItems, barcode;
	String itemName, imageName; //idk how else to store images in java yet
public:
	Food(int num, String name, int code, String imageName)
	{
		numItems = num;
		barcode = code;

	}
	void setCode(int code)
	{
		if(String.valueOf(code).length() == 12) //checks if barcode is 12 digits (which is how long barcodes are)
		{
			barcode = code;
		}
		else
		{
			barcode = 111222333444;
		}

	}
}