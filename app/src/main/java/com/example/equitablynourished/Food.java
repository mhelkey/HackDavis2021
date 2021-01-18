/**

this is an OOP class 
it will have food name, number, barcode, and pointer to an image of said food

Food(int num, String name, int code)

void setBarCode(int code) //sets the barcode
void setName(String name) //sets the name of fooditem
void setNum(int num) //sets num of food items

int returnNumitems(void)
int returnBarCode(void)
String returnItemname(void)



String printFood(void)


*/

package com.example.equitablynourished;
//package food;

public class Food
{

	public int numitems;

	public String itemname, barcode; //idk how else to store images in java yet

	public Food(int num, String name, String code)
	{
		setnumitems(num);
		setbarcode(code);
		setname(name);
	}
	public void setbarcode(String code) //sets the barcode
	{
		barcode = code;
	}
	public void setname(String name) //sets name of food item
	{
		itemname = name;
	}
	public void setnumitems(int num) //sets num of food items
	{
		if(num < 0)
		{
			numitems = 0;
		}
		else
		{
			numitems = num;
		}
	}



	public int returnnumitems()
	{
		return numitems;
	}
	public String returnbarcode()
	{
		return barcode;
	}
	public String returnitemname()
	{
		return itemname;
	}


	public String printFood()
	{
		return itemname + " Num: " + numitems + ". Barcode: " + barcode;
	}
}