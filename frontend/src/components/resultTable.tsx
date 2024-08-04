import "./table-style.css"

interface Candidato {
    nome: string;
    partido: string;
    quantidadeVotos: number;
    percentualVotos: number;
    cargo: string;
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
                    <th>Cargo</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{candidato.nome}</td>
                    <td>{candidato.partido}</td>
                    <td>{candidato.cargo}</td>
                </tr>
            </tbody>
        </table>
    );
}

export default ResultTable