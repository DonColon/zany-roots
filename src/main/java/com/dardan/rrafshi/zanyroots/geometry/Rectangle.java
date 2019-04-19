package com.dardan.rrafshi.zanyroots.geometry;

import java.util.Objects;


public final class Rectangle
{
	private final double x;
	private final double y;
	private final double width;
	private final double height;


	public Rectangle(final double x, final double y,
					 final double width, final double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Rectangle(final double width, final double height)
	{
		this(0, 0, width, height);
	}


	public boolean intersect(final double x, final double y, final double width, final double height)
	{
		if(x < this.x + this.width && x + width > this.x && y < this.y + this.height && y + height > this.y)
			return true;
		else
			return false;
	}

	public boolean intersect(final Rectangle other)
	{
		return this.intersect(other.x, other.y, other.width, other.height);
	}

	public boolean intersect(final double x, final double y, final double radius)
	{
		return this.intersect(new Circle(x, y, radius));
	}

	public boolean intersect(final Circle circle)
	{
		if(this.contains(circle.getCenter()))
			return true;

		final Vector[] corners = this.getCorners();

		for(final Vector corner : corners)
			if(circle.contains(corner))
				return true;

		if(circle.getCenterX() > this.x && circle.getCenterX() < this.x + this.width) {
			if(circle.contains(circle.getCenterX(), this.y))
				return true;

			if(circle.contains(circle.getCenterX(), this.y + this.height))
				return true;

		} else if(circle.getCenterY() > this.y && circle.getCenterY() < this.y + this.height) {
			if(circle.contains(this.x, circle.getCenterY()))
				return true;

			if(circle.contains(this.x + this.width, circle.getCenterY()))
				return true;
		}

		return false;
	}

	public boolean contains(final double x, final double y)
	{
		if(this.x <= x && this.x + this.width >= x && this.y <= y && this.y + this.height >= y)
			return true;
		else
			return false;
	}

	public boolean contains(final Vector vector)
	{
		return this.contains(vector.getX(), vector.getY());
	}


	@Override
	public String toString()
	{
		return "[x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Rectangle other = (Rectangle) object;
		return this.x == other.x
			&& this.y == other.y
			&& this.width == other.width
			&& this.height == other.height;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.x, this.y, this.width, this.height);
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
		return this.x + this.width / 2;
	}

	public double getCenterY()
	{
		return this.y + this.height / 2;
	}

	public Vector[] getCorners()
	{
		final Vector[] corners = new Vector[4];

		corners[0] = new Vector(this.x, this.y);
		corners[1] = new Vector(this.x + this.width, this.y);
		corners[2] = new Vector(this.x + this.width, this.y + this.height);
		corners[3] = new Vector(this.x, this.y + this.height);

		return corners;
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
