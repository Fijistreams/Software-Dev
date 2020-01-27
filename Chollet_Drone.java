/**
 *  @author Dominick Chollet
	1/19/2020
	Chollet_Drone
	Simulation using button, drone movement in x, y,z location
 */
package Chollet_Drone;

import java.util.Scanner;
//initialize variables
public class Chollet_Drone {

	int x = 0;
	int y = 0;
	int z = 0;
	int position = 0;
	
	//Methods to update x,y,z values and print position
	public void moveY(int num) {
		y = y + num;
	}
	
	public void moveX(int num) {
		x = x + num;
	}
	
	public void moveZ(int num) {
		z = z + num;
	}
	public void printPos() {
		
		System.out.println("Student drone [x_pos=" + x + ", y_pos=" + y + ", z_pos=" + z);
		
	}
	
	//Main function to take input and call methods to change values
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Chollet_Drone drone = new Chollet_Drone();
		int inputNum = 0;
		while(inputNum != 8) {
			
			System.out.println("Which direction would you like to move the drone?");
			System.out.println("1 - Move Up");
			System.out.println("2 - Move Down");
			System.out.println("3 - Move Forward");
			System.out.println("4 - Move Backward");
			System.out.println("5 - Turn Left");
			System.out.println("6 - Turn Rigt");
			System.out.println("7 - Display Position");
			System.out.println("8 - Exit Navigation");
			inputNum = scan.nextInt();
			
			if(inputNum == 1) {
				drone.moveY(1);
			}
			else if(inputNum == 2) {
				drone.moveY(-1);
			}
			else if(inputNum == 3) {
				drone.moveX(1);
			}
			else if(inputNum == 4) {
				drone.moveX(-1);
			}
			else if(inputNum == 5) {
				drone.moveZ(-1);
			}
			else if(inputNum == 6) {
				drone.moveZ(1);
			}
			else if(inputNum == 7) {
				drone.printPos();
			}
			
			
			
		}
		
	}
	}
	

