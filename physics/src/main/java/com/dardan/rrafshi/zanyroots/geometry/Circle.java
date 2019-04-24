package com.dardan.rrafshi.zanyroots.geometry;

import java.util.Objects;


public final class Circle
{
	private final Vector location;
	private final double radius;


	public Circle(final Vector location, final double radius)
	{
		this.location = location;
		this.radius = radius;
	}

	public Circle(final double x, final double y, final double radius)
	{
		this(new Vector(x, y), radius);
	}

	public Circle(final double radius)
	{
		this(new Vector(), radius);
	}


	public boolean intersect(final Circle other)
	{
		final Vector otherCenter = other.getCenter();
		final Vector selfCenter = this.getCenter();

		final double distance = selfCenter.distanceBetween(otherCenter);
		final double collisionDistance = this.radius + other.radius;

		if(distance < collisionDistance)
			return true;
		else
			return false;
	}

	public boolean contains(final Vector other)
	{
		final Vector center = this.getCenter();

		final double distance = center.distanceBetween(other);

		if(distance <= this.radius)
			return true;
		else
			return false;
	}


	@Override
	public String toString()
	{
		return "(location=" + this.location + ", radius=" + this.radius + ")";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Circle other = (Circle) object;
		return Objects.equals(this.location, other.location)
			&& Objects.equals(this.radius, other.radius);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.location, this.radius);
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
		final Vector center = new Vector(this.radius, this.radius);
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

	public double getRadius()
	{
		return this.radius;
	}

	public double getDiameter()
	{
		return 2 * this.radius;
	}
}
