'use client';

import Link from 'next/link';
import { usePathname } from 'next/navigation';

interface Props {
    path: string,
    label: string,
}

export default function NavbarItem({label, path}: Props) {

    const pathname = usePathname();

    return (
        <li className='py-4'>
            <Link href={path} className={`transition-all px-2 py-2 ${pathname===path ? 'bg-slate-600 text-slate-50' : 'bg-slate-400'} rounded-sm`}>
                {label}
            </Link>
        </li>
    );
}
