package com.dardan.rrafshi.zanyroots.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class Polygon
{
	private final List<Vector> vertices;


	public Polygon(final Vector... vertices)
	{
		this();
		for(final Vector point : vertices)
			this.vertices.add(point);
	}

	public Polygon(final Collection<Vector> vertices)
	{
		this();
		this.vertices.addAll(vertices);
	}

	public Polygon()
	{
		this.vertices = new ArrayList<>();
	}
}
