package com.dardan.rrafshi.zanyroots.geometry;

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

	public boolean contains(final double x, final double y)
	{
		if(this.x <= x && this.x + this.width >= x && this.y <= y && this.y + this.height >= y)
			return true;
		else
			return false;
	}

	public boolean contains(final Vector other)
	{
		return this.contains(other.getX(), other.getY());
	}


	public double getX()
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
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
