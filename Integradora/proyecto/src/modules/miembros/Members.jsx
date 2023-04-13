import React, { useEffect, useState } from 'react'
import Container from 'react-bootstrap/Container';
import { Table, Button, InputGroup, Form, Modal } from 'react-bootstrap';
import { show_alert } from '../../functions';
import FeatherIcon from "feather-icons-react";
import axios from 'axios';

import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content'

export const Members = () => {
    const apiUrl = 'http://54.164.31.87:8080/members/';

    const [members, setMembers] = useState([]);
    const [id, setId] = useState('');
    const [nombre, setNombre] = useState('');
    const [nacionalidad, setNacionalidad] = useState('');
    const [cumpleanos, setCumpleanios] = useState('');
    const [posicion, setPosicion] = useState('');

    const [title, setTitle] = useState('');

    useEffect(() => {
        getMembers();
    }, []);

    const getMembers = async () => {
        const respuesta = await axios.get(apiUrl);
        setMembers(respuesta.data)
    }

    const [show, setShow] = useState(false);
    const [showEliminar, setShowEliminar] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = (mode, id, nombre, nacionalidad, cumpleanios, posicion) => {
        setId('');
        setNombre('');
        setNacionalidad('');
        setCumpleanios('');
        setPosicion('');
        if (mode === "add") {
            setTitle('Registrar miembro');
        } else if (mode === "edit") {
            setTitle('Editar miembro');
            setId(id);
            setNombre(nombre);
            setNacionalidad(nacionalidad);
            setCumpleanios(cumpleanios);
            setPosicion(posicion);
        } else if (mode === "eliminar") {
            setShowEliminar(true);
        }
        /*window.setTimeout(function () {
            document.getElementById('nombre').focus();
        }, 500);*/
        setShow(true);
    }

    return (
        <>
            <Container>
                <div>
                    <br />
                    <h2>Integrantes</h2>
                        <button
                            type="button"
                            class="btn btn-primary btn-sm"
                            style={{float: 'right'}}
                            onClick={() => handleShow("add")}
                        >
                            +
                        </button>
                    <br />
                </div>
                <Table className='table table-hover'>
                    <thead>
                        <tr className='table-danger'>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Nacionalidad</th>
                            <th>Cumpleaños</th>
                            <th>Posicion</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {members.map((member, i) => (
                            <tr key={member.id} className="table-active">
                                <td>{(i + 1)}</td>
                                <td>{member.nombre}</td>
                                <td>{member.nacionalidad}</td>
                                <td>{member.cumpleanos}</td>
                                <td>{member.posicion}</td>
                                <td>
                                    <button
                                        type="button"
                                        class="btn btn-primary btn-sm"
                                        onClick={() => handleShow("edit")}
                                    >
                                        Editar
                                    </button>
                                </td>
                                <td>
                                    <button
                                        type="button"
                                        class="btn btn-danger btn-sm ms-2"
                                        /*onClick={() => handleShow("eliminar")}*/
                                    >
                                        Eliminar
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
            </Container >

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton className='titleModal'>
                    <Modal.Title>{title}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <InputGroup className="mb-3">
                        <InputGroup.Text id="basic-addon1">
                            <FeatherIcon icon={"slack"} style={{ stroke: 'pink' }} />
                        </InputGroup.Text>
                        <Form.Control
                            placeholder="Nombre"
                            aria-label="name"
                            aria-describedby="basic-addon1"
                            value={nombre} onChange={(e) => setNombre(e.target.value)}
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Text id="basic-addon1">
                            <FeatherIcon icon={"slack"} style={{ stroke: 'pink' }} />
                        </InputGroup.Text>
                        <Form.Control
                            placeholder="Nacionalidad"
                            aria-label="nacion"
                            aria-describedby="basic-addon1"
                            value={nacionalidad} onChange={(e) => setNacionalidad(e.target.value)}
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Text id="basic-addon1">
                            <FeatherIcon icon={"slack"} style={{ stroke: 'pink' }} />
                        </InputGroup.Text>
                        <Form.Control
                            placeholder="Cumpleaños"
                            aria-label="birthday"
                            aria-describedby="basic-addon1"
                            value={cumpleanos} onChange={(e) => setCumpleanios(e.target.value)}
                        />
                    </InputGroup>
                    <InputGroup className="mb-3">
                        <InputGroup.Text id="basic-addon1">
                            <FeatherIcon icon={"slack"} style={{ stroke: 'pink' }} />
                        </InputGroup.Text>
                        <Form.Control
                            placeholder="Posición"
                            aria-label="da"
                            aria-describedby="basic-addon1"
                            value={posicion} onChange={(e) => setPosicion(e.target.value)}
                        />
                    </InputGroup>
                </Modal.Body>
                <Modal.Footer>
                    <Button className='me-2' variant='outline-danger' onClick={handleClose}>
                        <FeatherIcon icon='x' />&nbsp;Cerrar
                    </Button>
                    <Button type='submit' variant='outline-success'>
                        <FeatherIcon icon='check' />&nbsp;Guardar
                    </Button>
                </Modal.Footer>
            </Modal>

            <Modal show={showEliminar} onHide={handleClose}>
                <Modal.Header closeButton className='titleModal'>
                    <Modal.Title>Eliminar</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <p>¿Está seguro de eliminarl@?</p>
                </Modal.Body>
                <Modal.Footer>
                    <Button className='me-2' variant='outline-danger' onClick={handleClose}>
                        <FeatherIcon icon='x' />&nbsp;Cancelar
                    </Button>
                    <Button type='submit' variant='outline-success'>
                        <FeatherIcon icon='check' />&nbsp;Aceptar
                    </Button>
                </Modal.Footer>
            </Modal>

        </>
    )
}

export default Members