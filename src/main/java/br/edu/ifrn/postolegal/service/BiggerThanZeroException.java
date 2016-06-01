package br.edu.ifrn.postolegal.service;

public class BiggerThanZeroException extends ValidationException
{
	private String field;

	public BiggerThanZeroException(String field)
	{
		super("O campo '" + field + "' deve ser maior que zero.");
		this.field = field;
	}

	public String getField()
	{
		return field;
	}
}
