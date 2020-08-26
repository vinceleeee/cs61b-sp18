public class Planet{
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  static final double G = 6.67e-11;

  public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Planet(Planet p){
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p){
    double dx = this.xxPos - p.xxPos;
    double dy = this.yyPos - p.yyPos;
    return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
  }

  public double calcForceExertedBy(Planet p){
    double r = this.calcDistance(p);
    double F = G * this.mass * p.mass / (r * r);
    return F;
  }

  public double calcForceExertedByX(Planet p){
    double dx = p.xxPos - this.xxPos;
    double r = this.calcDistance(p);
    double F = this.calcForceExertedBy(p);
    return F * dx / r;
  }

  public double calcForceExertedByY(Planet p){
    double dy = p.yyPos - this.yyPos;
    double r = this.calcDistance(p);
    double F = this.calcForceExertedBy(p);
    return F * dy / r;
  }

  public double calcNetForceExertedByX(Planet[] planetArray){
    double sumFx = 0;
    for (Planet p: planetArray){
      if (this.equals(p)) continue;
      else sumFx += this.calcForceExertedByX(p);
    }
    return sumFx;
  }

  public double calcNetForceExertedByY(Planet[] planetArray){
    double sumFy = 0;
    for (Planet p: planetArray){
      if (this.equals(p)) continue;
      else sumFy += this.calcForceExertedByY(p);
    }
    return sumFy;
  }

  public void update(double dt, double fX, double fY){
    double aX = fX / this.mass;
    double aY = fY / this.mass;
    this.xxVel += dt * aX;
    this.yyVel += dt * aY;
    this.xxPos += dt * this.xxVel;
    this.yyPos += dt * this.yyVel;
  }

  public void draw(){
    StdDraw.picture(this.xxPos, this.yyPos, "images/"+imgFileName);
  }
}
