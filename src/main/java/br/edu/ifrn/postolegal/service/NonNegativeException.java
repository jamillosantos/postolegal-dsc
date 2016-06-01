package br.edu.ifrn.postolegal.service;

public class NonNegativeException extends ValidationException
{
	private String field;

	public NonNegativeException(String field)
	{
		super("O campo '" + field + "' não pode ser menor que zero.");

		this.field = field;
	}

	public String getField()
	{
		return this.field;
	}
}
