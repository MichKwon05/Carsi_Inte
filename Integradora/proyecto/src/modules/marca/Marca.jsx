import React, { useEffect, useState } from 'react'
import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import { show_alert } from '../../functions';
import axios from 'axios';

export const Marca = () => {
  const apiUrl = 'http://localhost:8080/marcas/';

    const [marcas, setMarcas] = useState([]);
    const [id, setId] = useState('');
    const [nameMarca, setMarca] = useState('');
    const [member, setMember] = useState('');
    const [numComercials, setNumComercials] = useState('');
    const [ambassador, setAmbassador] = useState('');

    const [title, setTitle] = useState('');

    useEffect(() => {
        getMarcas();
    }, []);

    const getMarcas = async () => {
        const respuesta = await axios.get(apiUrl);
        setMarcas(respuesta.data)
    }

    return (
        <Container>
            <div>
                <br />
                <h2>Marca</h2>
                <br />
            </div>
            <Table className='table table-hover'>
                <thead>
                    <tr className='table-danger'>
                        <th>#</th>
                        <th>Nombre de la marca</th>
                        <th>Miembro</th>
                        <th>Numero de comerciales</th>
                        <th>Embajadora</th>
                    </tr>
                </thead>
                <tbody>
                    {marcas.map((marca, i) => (
                        <tr key={marca.id} className="table-active">
                            <td>{(i+1)}</td>
                            <td>{marca.nameMarca}</td>
                            <td>{marca.member}</td>
                            <td>{marca.numComercials}</td>
                            <td>{marca.ambassador}</td>
                        </tr>
                    ))
                    }

                </tbody>
            </Table>
        </Container>

    )
}

export default Marca