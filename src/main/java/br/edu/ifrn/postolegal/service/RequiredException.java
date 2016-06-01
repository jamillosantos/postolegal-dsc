package br.edu.ifrn.postolegal.service;

public class RequiredException extends ValidationException
{
	private String field;

	public RequiredException(String field)
	{
		super("O campo '" + field + "' deve ser preenchido.");

		this.field = field;
	}

	public String getField()
	{
		return this.field;
	}
}
