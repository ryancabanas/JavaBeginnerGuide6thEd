/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter08;

/**
 *
 * @author Ryan Cabanas
 */
public class Problem09_Vehicle implements Problem09_IVehicle {
  
  private int passengers;
  private int fuelCap;
  private int mpg;

  public Problem09_Vehicle(int passengers, int fuelCap, int mpg) {
    this.passengers = passengers;
    this.fuelCap = fuelCap;
    this.mpg = mpg;
  }

  @Override
  public int range() {
    return mpg * fuelCap;
  }
  
  @Override
  public double fuelNeeded(int miles) {
    return (double) miles / mpg;
  }
  
  //Accessor methods
  int getPassengers() { return passengers; }
  void setPassengers(int p) { passengers = p; }
  int getFuelCap() { return fuelCap; }
  void setFuelCap(int f) { fuelCap = f; }
  int getMpg() { return mpg; }
  void setMpg(int m) { mpg = m; }
  
}
