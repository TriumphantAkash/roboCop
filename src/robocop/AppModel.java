/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robocop;

import robocop.robostateenum.CameraStateEnum;
import robocop.robostateenum.ClawPositionEnum;
import robocop.robostateenum.DirectionEnum;
import robocop.robostateenum.RunningStateEnum;
import robocop.robostateenum.SpeedEnum;
import robocop.robostateenum.TemperatureSensorEnum;

/**
 *
 * @author Akash
 */
public class AppModel {
    private CameraStateEnum.CameraState cameraState;
    private ClawPositionEnum.ClawState clawState;
    private DirectionEnum.DirectionState directionState;
    private RunningStateEnum.RunningState runningState;
    private SpeedEnum.SpeedState speedState;
    private TemperatureSensorEnum.SensorState sensorState;
    private int armPosition;
    
    AppModel(){
        cameraState = CameraStateEnum.CameraState.OFF;
        clawState = ClawPositionEnum.ClawState.CLOSED;
        directionState = DirectionEnum.DirectionState.NORTH;
        runningState = RunningStateEnum.RunningState.STOPPPED;
        speedState = SpeedEnum.SpeedState.NULL;
    }

    //getters
    public void setCameraState(boolean cameraState) {
        if(cameraState == true){
            this.cameraState = CameraStateEnum.CameraState.ON;
        }else{
            this.cameraState = CameraStateEnum.CameraState.OFF;
        }
    }
    
    
    public void setSensorState(boolean sensorState) {
        if(sensorState == true){
            this.sensorState = TemperatureSensorEnum.SensorState.ON;
        }else{
            this.sensorState = TemperatureSensorEnum.SensorState.OFF;
        }
    }
    
    public void setClawState(ClawPositionEnum.ClawState clawState) {
        this.clawState = clawState;
                
    }
    
    public void setDirectionState(DirectionEnum.DirectionState directionState) {
        this.directionState = directionState;
    }
    
    public void setRunningState(RunningStateEnum.RunningState runningState) {
        this.runningState = runningState;
    }
    
    public void setSpeedState(SpeedEnum.SpeedState speedState) {
        this.speedState= speedState;
    }
   
    
    //setters
   public boolean getCameraState() {
       if(cameraState == CameraStateEnum.CameraState.ON) {
           return true;
       }else {
           return false;
       }   
   }
   
   public boolean getSensorState() {
       if(sensorState == TemperatureSensorEnum.SensorState.ON) {
           return true;
       }else {
           return false;
       }   
   }
   
   public ClawPositionEnum.ClawState getClawState() {
       return clawState;
   }
   
   public DirectionEnum.DirectionState getDirectionState() {
       return directionState;
   }
   
   public RunningStateEnum.RunningState getRunningState() {
       return runningState;
   }
   
   public SpeedEnum.SpeedState getSpeedState() {
       return speedState;
   }
   
   public int getArmPosition() {
       return armPosition;
               
   }
}
