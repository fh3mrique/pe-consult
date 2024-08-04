import "./table-style.css"

interface Candidato {
    nome: string;
    partido: string;
    /* quantidadeVotos: number;
    percentualVotos: number; */
    numeroPartido: string;
    qtdVotos: number;
    cargo: string;
    ano: number;
    situacao: string;
  }

interface ResultadoTableProps {
    candidato: Candidato | null;
}


const ResultTable: React.FC<ResultadoTableProps> = ({ candidato }) => {
    if (!candidato) {
        return <p>No results found.</p>;
    }

    return (
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Partido</th>
                    <th>Numero do partido</th>
                    <th>Cargo</th>
                    <th>Quantidade de votos</th>
                    <th>Situação</th>
                    <th>Ano</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{candidato.nome}</td>
                    <td>{candidato.partido}</td>
                    <td>{candidato.numeroPartido}</td>
                    <td>{candidato.cargo}</td>
                    <td>{candidato.qtdVotos}</td>
                    <td>{candidato.situacao}</td>
                    <td>{candidato.ano}</td>
                </tr>
            </tbody>
        </table>
    );
}

export default ResultTable