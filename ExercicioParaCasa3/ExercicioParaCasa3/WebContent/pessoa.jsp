<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pessoa</title>
</head>

<body>
 
	<f:view>

		<h:form> 

			<h:panelGrid columns="1"> 

				<h:outputLabel value="Nome:" />
				<h:inputText value="#{PessoaBean.nome }" />

				<h:outputLabel value="Idade:" />
				<h:inputText value="#{PessoaBean.idade }" />

				<h:outputLabel value="Telefone" />
				<h:inputText value="#{PessoaBean.telefone }" />

				<h:commandButton value="Exibir" action="#{PessoaBean.exibirDados }" />

			</h:panelGrid>

			<h:messages />

		</h:form>

	</f:view>
	
</body>

</html>