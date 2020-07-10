package Cr7;
import robocode.*;

//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * PapaiCris - a robot by (your name here)
 */
public class PapaiCris extends Robot
{
	boolean peek;
	double moveAmount; 

	public void run() {

		// Captura o tamanho do campo de batalha.
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		peek = false;// Começa não verificando
		// Vira a esquerda para ir até a parede.
		turnLeft(getHeading() % 90);
		ahead(moveAmount);
		// Movimenta a mira para direita e ativa a verificação.
		peek = true;
		turnGunRight(90);
		turnRight(90);

		while (true) {	
			peek = true;// Verifica até movimentar pela parede
			ahead(moveAmount);// Move pela parede
			peek = false;// Não verifica até virar para proxima parede
			turnRight(90);// Vira para proxima parede
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
	 double distance = e.getDistance(); //Pega a distância
    if(distance > 800) //reajusta a força
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

	public void onHitRobot(HitRobotEvent e) {
	
		if (e.getBearing() > -90 && e.getBearing() < 90) {// Se estiver proximo 
			back(100);
		} 
		else { // Se estiver longe
			ahead(100);
		}
	}


}
	

