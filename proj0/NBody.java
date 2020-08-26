public class NBody{

  public static double readRadius(String filePath){
    In file = new In(filePath);
    int planetCount = file.readInt();
    double radius = file.readDouble();
    return radius;
  }

  public static Planet[] readPlanets(String filePath){
    In file = new In(filePath);
    int planetCount = file.readInt();
    double radius = file.readDouble();
    Planet[] planetArray = new Planet[planetCount];
    for (int i=0; i<planetCount; i++){
      double xxPos = file.readDouble();
      double yyPos = file.readDouble();
      double xxVel = file.readDouble();
      double yyVel = file.readDouble();
      double mass = file.readDouble();
      String img = file.readString();
      planetArray[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
    }
    return planetArray;
  }

  public static void main(String[] args){
    StdDraw.enableDoubleBuffering();
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String fileName = args[2];
    double universeRadius = readRadius(fileName);
    Planet[] planetArray = readPlanets(fileName);
    StdDraw.setScale(-universeRadius, universeRadius);

    for (double time=0; time<=T; time+=dt){
      double[] xForces = new double[planetArray.length];
      double[] yForces = new double[planetArray.length];
      StdDraw.picture(0, 0, "images/starfield.jpg");
      for (int i=0; i<planetArray.length; i++){
        xForces[i] = planetArray[i].calcNetForceExertedByX(planetArray);
        yForces[i] = planetArray[i].calcNetForceExertedByY(planetArray);
        planetArray[i].update(dt, xForces[i], yForces[i]);
        planetArray[i].draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
    }
    StdOut.printf("%d\n", planetArray.length);
    StdOut.printf("%.2e\n", universeRadius);
    for (int i = 0; i < planetArray.length; i++) {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planetArray[i].xxPos, planetArray[i].yyPos, planetArray[i].xxVel,
                    planetArray[i].yyVel, planetArray[i].mass, planetArray[i].imgFileName);
}
  }
}
