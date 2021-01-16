
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
//import food.Food;
public class foodTest
{


	public static void main(String[] args) 
	{
		Food test= new Food(100, "Smoked Bacon", "123", "Null");
		System.out.println(test.printFood());
	}

}