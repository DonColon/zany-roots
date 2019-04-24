package com.dardan.rrafshi.zanyroots.geometry;

import java.util.Objects;


public final class Line
{
	private final Vector start;
	private final Vector end;


	public Line(final Vector start, final Vector end)
	{
		this.start = start;
		this.end = end;
	}

	public Line(final double startX, final double startY, final double endX, final double endY)
	{
		this(new Vector(startX, startY), new Vector(endX, endY));
	}


	public boolean intersect(final Line other)
	{
		final double firstNumerator = (other.getEndX() - other.getStartX()) * (this.getStartY() - other.getStartY()) -
				  					  (other.getEndY() - other.getStartY()) * (this.getStartX() - other.getStartX());

		final double secondNumerator = (this.getEndX() - this.getStartX()) * (this.getStartY() - other.getStartY()) -
			 	   					   (this.getEndY() - this.getStartY()) * (this.getStartX() - other.getStartX());

		final double denominator = (other.getEndY() - other.getStartY()) * (this.getEndX() - this.getStartX()) -
							 	   (other.getEndX() - other.getStartX()) * (this.getEndY() - this.getStartY());

		if(denominator == 0)
			return false;

		final double firstQuotient = firstNumerator / denominator;
		final double secondQuotient = secondNumerator / denominator;

		if(firstQuotient >= 0 && firstQuotient <= 1 && secondQuotient >= 0 && secondQuotient <= 1)
			return true;
		else
			return false;
	}

	public boolean contains(final Vector other)
	{
		final double distanceToStart = this.start.distanceBetween(other);
		final double distanceToEnd = this.end.distanceBetween(other);

		if(distanceToStart + distanceToEnd == this.getLength())
			return true;
		else
			return false;
	}


	@Override
	public String toString()
	{
		return "|start=" + this.start + ", end=" + this.end + "|";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Line other = (Line) object;
		return Objects.equals(this.start, other.start)
			&& Objects.equals(this.end, other.end);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.start, this.end);
	}


	public Vector getStart()
	{
		return this.start;
	}

	public double getStartX()
	{
		return this.start.getX();
	}

	public double getStartY()
	{
		return this.start.getY();
	}

	public Vector getCenter()
	{
		final Vector center = this.start.subtract(this.end).divide(2);
		return this.start.add(center);
	}

	public double getCenterX()
	{
		return this.getCenter().getX();
	}

	public double getCenterY()
	{
		return this.getCenter().getY();
	}

	public Vector getEnd()
	{
		return this.end;
	}

	public double getEndX()
	{
		return this.end.getX();
	}

	public double getEndY()
	{
		return this.end.getY();
	}

	public double getLength()
	{
		return this.start.distanceBetween(this.end);
	}
}
