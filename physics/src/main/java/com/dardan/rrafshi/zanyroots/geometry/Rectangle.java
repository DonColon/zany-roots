package com.dardan.rrafshi.zanyroots.geometry;

import java.util.Objects;


public final class Rectangle
{
	private final Vector location;
	private final double width;
	private final double height;


	public Rectangle(final Vector location, final double width, final double height)
	{
		this.location = location;
		this.width = width;
		this.height = height;
	}

	public Rectangle(final double x, final double y, final double width, final double height)
	{
		this(new Vector(x, y), width, height);
	}

	public Rectangle(final double width, final double height)
	{
		this(new Vector(), width, height);
	}


	public boolean intersect(final Rectangle other)
	{
		final Vector[] otherCorners = other.getCorners();
		final Vector[] selfCorners = this.getCorners();

		if(selfCorners[2].getX() >= otherCorners[0].getX() &&
		   selfCorners[0].getX() <= otherCorners[2].getX() &&
		   selfCorners[2].getY() >= otherCorners[0].getY() &&
		   selfCorners[0].getY() <= otherCorners[2].getY())
			return true;
		else
			return false;
	}

	public boolean contains(final Vector other)
	{
		final Vector[] corners = this.getCorners();

		if(other.getX() >= corners[0].getX() &&
		   other.getX() <= corners[2].getX() &&
		   other.getY() >= corners[0].getY() &&
		   other.getY() <= corners[2].getY())
			return true;
		else
			return false;
	}


	@Override
	public String toString()
	{
		return "[location=" + this.location + ", width=" + this.width + ", height=" + this.height + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Rectangle other = (Rectangle) object;
		return Objects.equals(this.location, other.location)
			&& Objects.equals(this.width, other.width)
			&& Objects.equals(this.height, other.height);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.location, this.width, this.height);
	}


	public Vector getLocation()
	{
		return this.location;
	}

	public double getLocationX()
	{
		return this.location.getX();
	}

	public double getLocationY()
	{
		return this.location.getY();
	}

	public Vector getCenter()
	{
		final Vector center = new Vector(this.width / 2, this.height / 2);
		return this.location.add(center);
	}

	public double getCenterX()
	{
		return this.getCenter().getX();
	}

	public double getCenterY()
	{
		return this.getCenter().getY();
	}

	public Vector[] getCorners()
	{
		final Vector[] corners = new Vector[4];
		corners[0] = this.location;
		corners[1] = this.location.add(new Vector(this.width, 0));
		corners[2] = this.location.add(new Vector(this.width, this.height));
		corners[3] = this.location.add(new Vector(0, this.height));
		return corners;
	}

	public Line[] getSides()
	{
		final Vector[] corners = this.getCorners();

		final Line[] sides = new Line[4];
		sides[0] = new Line(corners[0], corners[1]);
		sides[1] = new Line(corners[1], corners[2]);
		sides[2] = new Line(corners[2], corners[3]);
		sides[3] = new Line(corners[3], corners[0]);
		return sides;
	}

	public double getWidth()
	{
		return this.width;
	}

	public double getHeight()
	{
		return this.height;
	}
}
