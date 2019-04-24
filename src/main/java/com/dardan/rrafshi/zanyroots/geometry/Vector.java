package com.dardan.rrafshi.zanyroots.geometry;

import java.util.Objects;


public final class Vector
{
	private final double x;
	private final double y;
	private final double z;


	public Vector(final double x, final double y, final double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector(final double x, final double y)
	{
		this(x, y, 0);
	}

	public Vector()
	{
		this(0, 0);
	}


	public Vector add(final Vector other)
	{
		return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
	}

	public Vector subtract(final Vector other)
	{
		return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
	}

	public Vector multiply(final double scalar)
	{
		return new Vector(this.x * scalar, this.y * scalar, this.z * scalar);
	}

	public Vector divide(final double scalar)
	{
		if(scalar == 0)
			throw new ArithmeticException("Dividing by Zero is not allowed");

		return new Vector(this.x / scalar, this.y / scalar, this.z / scalar);
	}


	public double dot(final Vector other)
	{
		return this.x * other.x + this.y * other.y + this.z * other.z;
	}

	public Vector cross(final Vector other)
	{
		return new Vector(this.y * other.z - this.z * other.y,
				   		  this.z * other.x - this.x * other.z,
				   		  this.x * other.y - this.y * other.x);
	}

	public double magnitude()
	{
		return Math.sqrt(this.magnitudeSquared());
	}

	public double magnitudeSquared()
	{
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	public Vector normalize()
	{
		final double magnitude = this.magnitude();
		return this.divide(magnitude);
	}

	public double distanceBetween(final Vector other)
	{
		final Vector vector = other.subtract(this);
		return vector.magnitude();
	}

	public double angleBetween(final Vector other)
	{
		final double numerator = this.dot(other);
		final double denominator = this.magnitude() * other.magnitude();
		return Math.toDegrees(Math.acos(numerator/denominator));
	}

	public boolean isCollinear(final Vector other)
	{
		final double checkX = this.x / other.x;
		final double checkY = this.y / other.y;
		final double checkZ = this.z / other.z;

		if(checkX == checkY || checkY == checkZ || checkZ == checkX)
			return true;
		else
			return false;
	}

	public boolean isVertical(final Vector other)
	{
		if(this.dot(other) == 0)
			return true;
		else
			return false;
	}


	@Override
	public String toString()
	{
		return "[" + this.x + " | " + this.y + " | " + this.z + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Vector other = (Vector) object;
		return this.x == other.x
			&& this.y == other.y
			&& this.z == other.z;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.x, this.y, this.z);
	}


	public double getX()
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

	public double getZ()
	{
		return this.z;
	}
}
