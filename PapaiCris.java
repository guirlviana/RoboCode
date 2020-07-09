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
			back(100);
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
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(100);
		ahead(100);
		turnRight(100);
		ahead(100);
		
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(100);
		turnRight(100);
		ahead(100);
		
		
		
	}	
}
