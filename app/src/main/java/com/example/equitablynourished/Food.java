/**

this is an OOP class 
it will have food name, number, barcode, and pointer to an image of said food

Food(int num, String name, int code, String imageName)

void setBarCode(int code) //sets the barcode
void setName(String name) //sets the name of fooditem
void setNum(int num) //sets num of food items

int returnNumItems(void)
int returnBarCode(void)
String returnItemName(void)
String returnImageName(void)


String printFood(void)


*/

package com.example.equitablynourished;
//package food;

public class Food
{

	private int numItems;

	private String itemName, barcode; //idk how else to store images in java yet

	public Food(int num, String name, String code)
	{
		setNum(num);
		setBarCode(code);
		setName(name);
	}
	public void setBarCode(String code) //sets the barcode
	{
		barcode = code;
	}
	public void setName(String name) //sets name of food item
	{
		itemName = name;
	}
	public void setNum(int num) //sets num of food items
	{
		if(num < 0)
		{
			numItems = 0;
		}
		else
		{
			numItems = num;
		}
	}



	public int returnNumItems()
	{
		return numItems;
	}
	public String returnBarCode()
	{
		return barcode;
	}
	public String returnItemName()
	{
		return itemName;
	}


	public String printFood()
	{
		return itemName + " Num: " + numItems + ". Barcode: " + barcode;

	}

}