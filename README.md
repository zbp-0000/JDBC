#   J D B C  
  
 # #   �W@x�{ 
  
 (W9h�vU_NR�^` l i b ` �e�N9Y��b` j u n i t - 4 . 1 2 . j a r ` �` h a m c r e s t - 2 . 2 . j a r ` >eۏ�S�6qT�S.�l i b �e�N9Y�	��b` �m�R:N�^` = > ` y��v�^`  
  
 R�^` J D B C O p e r a t i o n ` j a v a {| 
  
 ` ` ` j a v a  
 p a c k a g e   c o m . a t g u i g u . b a s e ;  
  
 i m p o r t   o r g . j u n i t . T e s t ;  
  
 i m p o r t   j a v a . s q l . * ;  
  
 p u b l i c   c l a s s   J D B C O p e r a t i o n   {  
         @ T e s t  
         p u b l i c   v o i d   t e s t Q u e r y S i n g l e R o w A n d C o l   ( )   t h r o w s   S Q L E x c e p t i o n   {  
                 / /   �l�Qq��R  j d k 6 KNTN(u>f:y�v�Q 
  
                 / /   2 . ���Sޏ�c 
                 C o n n e c t i o n   c o n n e c t i o n   =   D r i v e r M a n a g e r . g e t C o n n e c t i o n ( " j d b c : m y s q l : / / l o c a l h o s t : 3 3 0 6 / a t g u i g u " ,   " r o o t " ,   " r o o t " ) ;  
  
                 / /   3 . ��ыs q l ��S 
                 P r e p a r e d S t a t e m e n t   p r e p a r e d S t a t e m e n t   =   c o n n e c t i o n . p r e p a r e S t a t e m e n t ( " S E L E C T   C O U N T ( * )   a s   c o u n t   F R O M   t _ e m p " ) ;  
  
                 / /   4 . gbL�s q l ��S���S�~�g 
                 R e s u l t S e t   r e s u l t S e t   =   p r e p a r e d S t a t e m e n t . e x e c u t e Q u e r y ( ) ;  
  
                 / /   5 . Yt�~�g 
                 w h i l e   ( r e s u l t S e t . n e x t ( ) )   {  
                         i n t   c o u n t   =   r e s u l t S e t . g e t I n t ( " c o u n t " ) ;  
                         S y s t e m . o u t . p r i n t l n ( c o u n t ) ;  
                 }  
  
                 / /   6 . ʑ>eD��n 
                 r e s u l t S e t . c l o s e ( ) ;  
                 p r e p a r e d S t a t e m e n t . c l o s e ( ) ;  
                 c o n n e c t i o n . c l o s e ( ) ;  
         }  
  
         @ T e s t  
         p u b l i c   v o i d   t e s t Q u e r y S i n g l e R o w ( )   t h r o w s   E x c e p t i o n   {  
                 / /   �l�Qq��R  j d k 6 KNTN(u>f:y�v�Q 
  
                 / /   2 . ���Sޏ�c 
                 C o n n e c t i o n   c o n n e c t i o n   =   D r i v e r M a n a g e r . g e t C o n n e c t i o n ( " j d b c : m y s q l : / / l o c a l h o s t : 3 3 0 6 / a t g u i g u " ,   " r o o t " ,   " r o o t " ) ;  
  
                 S t r i n g   s q l   =   " S E L E C T   e m p _ i d ,   e m p _ n a m e ,   e m p _ s a l a r y ,   e m p _ a g e   f r o m   t _ e m p   W H E R E   e m p _ i d   =   ? " ;  
                 / /   3 . ��ыs q l ��S 
                 P r e p a r e d S t a t e m e n t   p r e p a r e d S t a t e m e n t   =   c o n n e c t i o n . p r e p a r e S t a t e m e n t ( s q l ) ;  
  
                 / /   4 . gbL�s q l ��S���S�~�g 
                 p r e p a r e d S t a t e m e n t . s e t I n t ( 1 ,   5 ) ;   / /   �~,{ N*N�Spe�K�<P:N5  
                 R e s u l t S e t   r e s u l t S e t   =   p r e p a r e d S t a t e m e n t . e x e c u t e Q u e r y ( ) ;  
  
                 / /   5 . Yt�~�g 
                 w h i l e   ( r e s u l t S e t . n e x t ( ) )   {  
                         i n t   e m p I d   =   r e s u l t S e t . g e t I n t ( " e m p _ i d " ) ;  
                         S t r i n g   e m p N a m e   =   r e s u l t S e t . g e t S t r i n g ( " e m p _ n a m e " ) ;  
                         d o u b l e   e m p S a l a r y   =   r e s u l t S e t . g e t D o u b l e ( " e m p _ s a l a r y " ) ;  
                         i n t   e m p A g e   =   r e s u l t S e t . g e t I n t ( " e m p _ a g e " ) ;  
                         S y s t e m . o u t . p r i n t l n ( e m p I d + " \ t " + e m p N a m e + " \ t " + e m p S a l a r y + " \ t " + e m p A g e ) ;  
                 }  
  
                 / /   6 . ʑ>eD��n 
                 r e s u l t S e t . c l o s e ( ) ;  
                 p r e p a r e d S t a t e m e n t . c l o s e ( ) ;  
                 c o n n e c t i o n . c l o s e ( ) ;  
         }  
  
         @ T e s t  
         p u b l i c   v o i d   t e s t Q u e r y M o r e R o w ( )   t h r o w s     E x c e p t i o n   {  
                 C o n n e c t i o n   c o n n e c t i o n   =   D r i v e r M a n a g e r . g e t C o n n e c t i o n ( " j d b c : m y s q l : / / l o c a l h o s t : 3 3 0 6 / a t g u i g u " ,   " r o o t " ,   " r o o t " ) ;  
                 S t r i n g   s q l   =   " S E L E C T   e m p _ i d ,   e m p _ n a m e ,   e m p _ s a l a r y ,   e m p _ a g e   f r o m   t _ e m p   W H E R E   e m p _ a g e   >   ? " ;  
                 P r e p a r e d S t a t e m e n t   p r e p a r e d S t a t e m e n t   =   c o n n e c t i o n . p r e p a r e S t a t e m e n t ( s q l ) ;  
                 p r e p a r e d S t a t e m e n t . s e t I n t ( 1 ,   3 0 ) ;   / /   �~,{ N*N�Spe�K�<P:N5  
                 R e s u l t S e t   r e s u l t S e t   =   p r e p a r e d S t a t e m e n t . e x e c u t e Q u e r y ( ) ;  
                 w h i l e   ( r e s u l t S e t . n e x t ( ) )   {  
                         i n t   e m p I d   =   r e s u l t S e t . g e t I n t ( " e m p _ i d " ) ;  
                         S t r i n g   e m p N a m e   =   r e s u l t S e t . g e t S t r i n g ( " e m p _ n a m e " ) ;  
                         d o u b l e   e m p S a l a r y   =   r e s u l t S e t . g e t D o u b l e ( " e m p _ s a l a r y " ) ;  
                         i n t   e m p A g e   =   r e s u l t S e t . g e t I n t ( " e m p _ a g e " ) ;  
                         S y s t e m . o u t . p r i n t l n ( e m p I d + " \ t " + e m p N a m e + " \ t " + e m p S a l a r y + " \ t " + e m p A g e ) ;  
                 }  
                 r e s u l t S e t . c l o s e ( ) ;  
                 p r e p a r e d S t a t e m e n t . c l o s e ( ) ;  
                 c o n n e c t i o n . c l o s e ( ) ;  
         }  
  
         / /   �X�R 
         @ T e s t  
         p u b l i c   v o i d   t e s t I n s e r t ( )   t h r o w s   E x c e p t i o n   {  
                 C o n n e c t i o n   c o n n e c t i o n   =   D r i v e r M a n a g e r . g e t C o n n e c t i o n ( " j d b c : m y s q l : / / l o c a l h o s t : 3 3 0 6 / a t g u i g u " ,   " r o o t " ,   " r o o t " ) ;  
                 S t r i n g   s q l   =   " I N S E R T   I N T O   t _ e m p ( e m p _ n a m e ,   e m p _ s a l a r y ,   e m p _ a g e )   V A L U E S   ( ? , ? , ? ) " ;  
                 P r e p a r e d S t a t e m e n t   p r e p a r e d S t a t e m e n t   =   c o n n e c t i o n . p r e p a r e S t a t e m e n t ( s q l ) ;  
                 p r e p a r e d S t a t e m e n t . s e t S t r i n g ( 1 ,   " Ng�V" ) ;   / /   �~,{ N*N�Spe�K�<P:N5  
                 p r e p a r e d S t a t e m e n t . s e t D o u b l e ( 2 ,   5 2 9 9 ) ;   / /   �~,{ N*N�Spe�K�<P:N5  
                 p r e p a r e d S t a t e m e n t . s e t I n t ( 3 ,   1 8 ) ;   / /   �~,{ N*N�Spe�K�<P:N5  
                 i n t   r e s u l t   =   p r e p a r e d S t a t e m e n t . e x e c u t e U p d a t e ( ) ;   / /   �X R9e  (u  e x e c u t e U p d a t e  
  
                 / /   9hnc�Sq_�TL�pe�ZP$R�e��_0Rb�Rb1Y%� 
                 i f ( r e s u l t   >   0 )   {  
                         S y s t e m . o u t . p r i n t l n ( " b�R: " + r e s u l t ) ;  
                 }   e l s e   {  
                         S y s t e m . o u t . p r i n t l n ( " 1Y%�: " + r e s u l t ) ;  
                 }  
  
                 p r e p a r e d S t a t e m e n t . c l o s e ( ) ;  
                 c o n n e c t i o n . c l o s e ( ) ;  
         }  
  
         / /   �O9e 
         @ T e s t  
         p u b l i c   v o i d   t e s t U p d a t e ( )   t h r o w s   E x c e p t i o n   {  
                 C o n n e c t i o n   c o n n e c t i o n   =   D r i v e r M a n a g e r . g e t C o n n e c t i o n ( " j d b c : m y s q l : / / l o c a l h o s t : 3 3 0 6 / a t g u i g u " ,   " r o o t " ,   " r o o t " ) ;  
                 S t r i n g   s q l   =   " U P D A T E   t _ e m p   S E T   e m p _ s a l a r y   =   ?   W H E R E   e m p _ i d   =   ? " ;  
                 P r e p a r e d S t a t e m e n t   p r e p a r e d S t a t e m e n t   =   c o n n e c t i o n . p r e p a r e S t a t e m e n t ( s q l ) ;  
                 p r e p a r e d S t a t e m e n t . s e t D o u b l e ( 1 ,   5 2 9 9 ) ;   / /   �~,{ N*N�Spe�K�<P:N5  
                 p r e p a r e d S t a t e m e n t . s e t I n t ( 2 ,   1 ) ;   / /   �~,{ N*N�Spe�K�<P:N5  
                 i n t   r e s u l t   =   p r e p a r e d S t a t e m e n t . e x e c u t e U p d a t e ( ) ;   / /   �X R9e  (u  e x e c u t e U p d a t e  
  
                 / /   9hnc�Sq_�TL�pe�ZP$R�e��_0Rb�Rb1Y%� 
                 i f ( r e s u l t   >   0 )   {  
                         S y s t e m . o u t . p r i n t l n ( " b�R: " + r e s u l t ) ;  
                 }   e l s e   {  
                         S y s t e m . o u t . p r i n t l n ( " 1Y%�: " + r e s u l t ) ;  
                 }  
  
                 p r e p a r e d S t a t e m e n t . c l o s e ( ) ;  
                 c o n n e c t i o n . c l o s e ( ) ;  
         }  
  
         / /    Rd� 
         @ T e s t  
         p u b l i c   v o i d   t e s t D e l e t e ( )   t h r o w s   E x c e p t i o n   {  
                 C o n n e c t i o n   c o n n e c t i o n   =   D r i v e r M a n a g e r . g e t C o n n e c t i o n ( " j d b c : m y s q l : / / l o c a l h o s t : 3 3 0 6 / a t g u i g u " ,   " r o o t " ,   " r o o t " ) ;  
                 S t r i n g   s q l   =   " D E L E T E   F R O M   t _ e m p   W H E R E   e m p _ i d   =   ? " ;  
                 P r e p a r e d S t a t e m e n t   p r e p a r e d S t a t e m e n t   =   c o n n e c t i o n . p r e p a r e S t a t e m e n t ( s q l ) ;  
                 p r e p a r e d S t a t e m e n t . s e t I n t ( 1 ,   9 ) ;   / /   �~,{ N*N�Spe�K�<P:N5  
                 i n t   r e s u l t   =   p r e p a r e d S t a t e m e n t . e x e c u t e U p d a t e ( ) ;   / /   �X R9e  (u  e x e c u t e U p d a t e  
  
                 / /   9hnc�Sq_�TL�pe�ZP$R�e��_0Rb�Rb1Y%� 
                 i f ( r e s u l t   >   0 )   {  
                         S y s t e m . o u t . p r i n t l n ( " b�R: " + r e s u l t ) ;  
                 }   e l s e   {  
                         S y s t e m . o u t . p r i n t l n ( " 1Y%�: " + r e s u l t ) ;  
                 }  
  
                 p r e p a r e d S t a t e m e n t . c l o s e ( ) ;  
                 c o n n e c t i o n . c l o s e ( ) ;  
         }  
 }  
  
 ` ` `  
  
 