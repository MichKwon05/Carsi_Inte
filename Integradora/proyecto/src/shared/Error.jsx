import React from 'react'
import Container from 'react-bootstrap/esm/Container'

export const Error = () => {
    return (
        <Container style={{ display: "flex", justifyContent: "center", alignItems: "center", padding: '150px'}}>
            <div className="card text-white bg-secondary mb-3" style={{ maxWidth: '20rem' }}>
                <div className="card-header">ERROR</div>
                <div className="card-body">
                    <h4 className="card-title">Página no encontrada</h4>
                    <p className="card-text">La página que buscas no existe. Favor de seleccionar alguna de las opciones del menú</p>
                </div>
            </div>
        </Container>

    )
}

export default Error
