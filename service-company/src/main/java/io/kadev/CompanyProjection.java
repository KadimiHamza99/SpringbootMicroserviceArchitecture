package io.kadev;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p",types = {Company.class})
public interface CompanyProjection {
	public String getNom();
	public double getPrice();
}