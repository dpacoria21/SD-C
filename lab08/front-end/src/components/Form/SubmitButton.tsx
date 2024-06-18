'use client';
 
import { useFormStatus } from 'react-dom';
 
interface Props {
    label: string,
}

export function SubmitButton({label}: Props) {
    const { pending } = useFormStatus();
 
    return (
        <button className='px-3 py-1 bg-slate-700 text-slate-50 text-lg rounded-sm w-full' type="submit" disabled={pending}>
            {label}
        </button>
    );
}