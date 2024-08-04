import React, { useState } from "react";
import ResultTable from "./resultTable";

interface Candidato {
  nome: string;
  partido: string;
  quantidadeVotos: number;
  percentualVotos: number;
  cargo: string;
}

interface ResultadoRequest {
  nome: string;
  cargo: string;
  ano: number;
}

const ResultForm: React.FC = () => {
  const [nome, setNome] = useState("");
  const [cargo, setCargo] = useState("");
  const [ano, setAno] = useState<number | "">(2014);
  const [resultado, setResultado] = useState<Candidato | null>(null);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    const requestData: ResultadoRequest = {
      nome,
      cargo,
      ano: typeof ano === "number" ? ano : parseInt(ano),
    };

    const response = await fetch("http://localhost:8080/api/candidatos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestData),
    });

    const data: Candidato = await response.json();
    setResultado(data);
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div className="input-container">
          <label>Nome:</label>
          <input
            className="input-default"
            type="text"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
          />
        </div>
        <div className="input-container">
          <label>Cargo:</label>
          <select
            className="input-default"
            value={cargo}
            onChange={(e) => setCargo(e.target.value)}
          >
            <option value="">Selecione um cargo</option>
            <option value="Governador">Governador</option>
            <option value="Deputado Estadual">Deputado Estadual</option>
          </select>
        </div>
        <div className="input-container">
          <label>Ano:</label>
          <select
            className="input-default"
            value={ano}
            onChange={(e) => setAno(parseInt(e.target.value))}
          >
            <option value={2014}>2014</option>
          </select>
        </div>
        <button className="btn" type="submit">Buscar</button>
      </form>

      <ResultTable candidato={resultado} />
    </div>
  );
};

export default ResultForm;
