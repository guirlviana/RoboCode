package Cr7;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * PapaiCris - a robot by (your name here)
 */
public class PapaiCris extends Robot
{

	public void run() {
	
		while(true) {
			ahead(100);
			turnGunRight(360);
			back(70);
			turnGunRight(360);
			
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
	 double distance = e.getDistance(); //get the distance of the scanned robot
    if(distance > 800) //this conditions adjust the fire force according the distance of the scanned robot.
        fire(5);
    else if(distance > 600 && distance <= 800)
        fire(4);
    else if(distance > 400 && distance <= 600)
        fire(3);
    else if(distance > 200 && distance <= 400)
        fire(2);
    else if(distance < 200)
        fire(1);
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */

	public void onHitByBullet(HitByBulletEvent e){
	double energy = getEnergy();
    double bearing = e.getBearing(); //Get the direction which is arrived the bullet.
    if(energy < 100){ // if the energy is low, the robot go away from the enemy
        turnRight(-bearing); //This isn't accurate but release your robot.
        ahead(100); //The robot goes away from the enemy.
    }else{
        turnRight(360); // scan
	}
}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
    double bearing2 = e.getBearing(); 
    turnRight(-bearing2);
    ahead(100);
			
	}	
}
