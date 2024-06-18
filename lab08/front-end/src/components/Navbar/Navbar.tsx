import NavbarItem from './NavbarItem';

interface Route {
    label: string,
    path: string,
}

const routes: Route[] = [
    {
        path: '/',
        label: 'Inicio'
    },
    {
        path: '/ingenieros',
        label: 'Ingenieros'
    },
    {
        path: '/departamentos',
        label: 'Departamentos'
    },
    {
        path: '/proyectos',
        label: 'Proyectos'
    },
    {
        path: '/busquedas',
        label: 'Búsquedas'
    }
];

export default function Navbar() {
    return (
        <nav>
            <ul className="list-none flex gap-4">
                {
                    routes.map((route, i) => (
                        <NavbarItem key={route.path+i} {...route}/>
                    ))
                }
            </ul>
        </nav>
    );
}
