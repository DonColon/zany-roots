package com.dardan.rrafshi.zanyroots.geometry;

import java.util.Objects;

public final class Circle
{
	private final double x;
	private final double y;
	private final double radius;


	public Circle(final double x, final double y, final double radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public Circle(final double radius)
	{
		this(0, 0, radius);
	}


	public boolean intersect(final double x, final double y, final double radius)
	{
		return this.intersect(new Circle(x, y, radius));
	}

	public boolean intersect(final Circle other)
	{
		final Vector selfCenter = this.getCenter();
		final Vector otherCenter = other.getCenter();

		final double distance = selfCenter.distanceBetween(otherCenter);
		final double collisionDistance = this.radius + other.radius;

		if(distance < collisionDistance)
			return true;
		else
			return false;
	}

	public boolean intersect(final double x, final double y, final double width, final double height)
	{
		return this.intersect(new Rectangle(x, y, width, height));
	}

	public boolean intersect(final Rectangle rectangle)
	{
		if(rectangle.contains(this.getCenter()))
			return true;

		final Vector[] corners = rectangle.getCorners();

		for(final Vector corner : corners)
			if(this.contains(corner))
				return true;

		if(this.getCenterX() > rectangle.getX() && this.getCenterX() < rectangle.getX() + rectangle.getWidth()) {
			if(this.contains(this.getCenterX(), rectangle.getY()))
				return true;

			if(this.contains(this.getCenterX(), rectangle.getY() + rectangle.getHeight()))
				return true;

		} else if(this.getCenterY() > this.y && this.getCenterY() < rectangle.getY() + rectangle.getHeight()) {
			if(this.contains(rectangle.getX(), this.getCenterY()))
				return true;

			if(this.contains(rectangle.getX() + rectangle.getWidth(), this.getCenterY()))
				return true;
		}

		return false;
	}

	public boolean contains(final double x, final double y)
	{
		return this.contains(new Vector(x, y));
	}

	public boolean contains(final Vector other)
	{
		final Vector self = this.getCenter();

		final double distance = self.distanceBetween(other);

		if(distance < this.radius)
			return true;
		else
			return false;
	}


	@Override
	public String toString()
	{
		return "(x=" + this.x + ", y=" + this.y + ", radius=" + this.radius + ")";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Circle other = (Circle) object;
		return this.x == other.x
			&& this.y == other.y
			&& this.radius == other.radius;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.x, this.y, this.radius);
	}


	public Vector getLocation()
	{
		return new Vector(this.x, this.y);
	}

	public double getX()
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

	public Vector getCenter()
	{
		return new Vector(this.getCenterX(), this.getCenterY());
	}

	public double getCenterX()
	{
		return this.x + this.radius;
	}

	public double getCenterY()
	{
		return this.y + this.radius;
	}

	public double getRadius()
	{
		return this.radius;
	}
}
